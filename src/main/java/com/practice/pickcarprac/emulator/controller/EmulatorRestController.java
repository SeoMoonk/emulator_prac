package com.practice.pickcarprac.emulator.controller;

import com.practice.pickcarprac.emulator.service.EmulatorService;
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

    @PostMapping("/on/{emulatorId}")
    public ResponseEntity<String> on(@PathVariable(value = "emulatorId") Long emulatorId) {
        log.info("On => input emulatorId: {}", emulatorId);
        emulatorService.turnOn(emulatorId);
        //todo: 스케줄러 시작

        return ResponseEntity.ok("%d번 애뮬레이터가 동작하기 시작합니다.".formatted(emulatorId));
    }

    @PostMapping("/receive")
    public void receive() {
        //Todo: step2. 주기 데이터를 전달받음
    }

    @PostMapping("/off/{emulatorId}")
    public ResponseEntity<String> off(@PathVariable(value = "emulatorId") Long emulatorId) {
        log.info("Off => input emulatorId: {}", emulatorId);
        emulatorService.turnOff(emulatorId);
        //todo: 스케줄러 중단

        return ResponseEntity.ok("%d번 애뮬레이터가 종료되었습니다.".formatted(emulatorId));
    }
}
