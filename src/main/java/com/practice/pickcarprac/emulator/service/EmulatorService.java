package com.practice.pickcarprac.emulator.service;

import com.practice.pickcarprac.emulator.entity.Emulator;
import com.practice.pickcarprac.emulator.repository.EmulatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
        Optional<Emulator> maybeEmulator = emulatorRepository.findById(emulatorId);

        if (maybeEmulator.isEmpty()) {
            throw new IllegalArgumentException("Emulator not found");
        }

        return maybeEmulator.get();
    }
}
