package com.practice.pickcarprac.global.base;

import com.practice.pickcarprac.emulator.model.entity.Emulator;
import com.practice.pickcarprac.emulator.repository.EmulatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final EmulatorRepository emulatorRepository;

    @Override
    public void run(String... args) throws Exception {

        emulatorRepository.saveAll(
                IntStream.iterate(1, i -> i + 1)
                        .limit(10)
                        .mapToObj(i -> new Emulator(
                                "EM00" + i
                        ))
                        .toList());
    }
}
