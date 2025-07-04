package com.practice.emulator.controller;

import com.practice.emulator.service.EmulatorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/emulator")
@RequiredArgsConstructor
public class EmulatorRestController {

    private final EmulatorService emulatorService;

    //1. 애뮬레이터를 on 상태로 만듬
    @PostMapping("/on/{emulatorId}")
    public ResponseEntity<String> on(@PathVariable(value = "emulatorId") Long emulatorId, HttpServletRequest request) {
        log.info("On => input emulatorId: {}", emulatorId);
        emulatorService.turnOn(emulatorId);
        return ResponseEntity.ok("%d번 애뮬레이터가 동작하기 시작합니다.".formatted(emulatorId));
    }


    //3. 애뮬레이터를 off 상태로 만듬
    @PostMapping("/off/{emulatorId}")
    public ResponseEntity<String> off(@PathVariable(value = "emulatorId") Long emulatorId) {
        log.info("Off => input emulatorId: {}", emulatorId);
        emulatorService.turnOff(emulatorId);
        return ResponseEntity.ok("%d번 애뮬레이터가 종료되었습니다.".formatted(emulatorId));
    }
}
