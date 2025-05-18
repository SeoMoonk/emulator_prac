package com.practice.emulator.service;

import com.practice.emulator.model.entity.Emulator;
import com.practice.emulator.repository.EmulatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class EmulatorService {

    private final RestClient restClient = RestClient.create();
    private final EmulatorRepository emulatorRepository;

    @Transactional
    public void save(Emulator emulator) {
        emulatorRepository.save(emulator);
    }

    @Transactional
    public void turnOn(Long emulatorId) {
        Emulator emulator = getById(emulatorId);
        emulator.turnOn(emulator);
    }

    @Transactional
    public void turnOff(Long emulatorId) {
        Emulator emulator = getById(emulatorId);
        emulator.turnOff(emulator);

        //todo : 수신 서버에게 지금까지의 남은 데이터를 마저 저장하도록 요청
        restClient.post()
                .uri("http://localhost:8081/api/v1/reciever/off-save/" + emulatorId)
                .retrieve()
                .toBodilessEntity();
    }

    private Emulator getById(Long emulatorId) {
        //todo: fix to stream
        Optional<Emulator> maybeEmulator = emulatorRepository.findById(emulatorId);

        if (maybeEmulator.isEmpty()) {
            throw new IllegalArgumentException("Emulator not found");
        }

        return maybeEmulator.get();
    }

    public List<Long> getRunningIds() {
        return emulatorRepository.findAllByIsRunningTrue().stream()
                .map(Emulator::getId)
                .toList();
    }
}
