package com.practice.pickcarprac.emulator.controller;

import com.practice.pickcarprac.emulator.service.EmulatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emulator")
@RequiredArgsConstructor
@Slf4j
public class EmulatorRestController {

    private final EmulatorService emulatorService;

    @PostMapping("/on/{emulatorId}")
    public void on(@PathVariable(value = "emulatorId") Long emulatorId) {
        //Todo: step1. 시동이 켜짐
        log.debug("On => input emulatorId: {}", emulatorId);
    }

    @PostMapping("/receive")
    public void receive() {
        //Todo: step2. 주기 데이터를 전달받음
    }

    @PostMapping("/off/{emulatorId}")
    public void off(@PathVariable(value = "emulatorId") Long emulatorId) {
        //Todo: step3. 시동이 꺼짐
        log.debug("Off => input emulatorId: {}", emulatorId);
    }
}
