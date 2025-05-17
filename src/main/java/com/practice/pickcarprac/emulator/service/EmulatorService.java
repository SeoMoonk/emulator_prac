package com.practice.pickcarprac.emulator.service;

import com.practice.pickcarprac.emulator.entity.Emulator;
import com.practice.pickcarprac.emulator.repository.EmulatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmulatorService {

    private final EmulatorRepository emulatorRepository;

    @Transactional
    public void save(Emulator emulator) {
        emulatorRepository.save(emulator);
    }

}
