package com.practice.emulator.service;

import com.practice.emulator.model.entity.Emulator;
import com.practice.emulator.repository.EmulatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class EmulatorService {

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
