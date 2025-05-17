package com.practice.pickcarprac.emulator.controller;

import com.practice.pickcarprac.emulator.model.entity.Gps;
import com.practice.pickcarprac.emulator.service.EmulatorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/emulator")
@RequiredArgsConstructor
public class EmulatorRestController {

    private final EmulatorService emulatorService;
    private final EmulatorEventScheduler emulatorEventScheduler;

    @PostMapping("/on/{emulatorId}")
    public ResponseEntity<String> on(@PathVariable(value = "emulatorId") Long emulatorId, HttpServletRequest request) {
        log.info("On => input emulatorId: {}", emulatorId);
        emulatorService.turnOn(emulatorId);
        return ResponseEntity.ok("%d번 애뮬레이터가 동작하기 시작합니다.".formatted(emulatorId));
    }

    @PostMapping("/receive")
    public ResponseEntity<Void> receive(@RequestBody List<Gps> gpses) {
        //Todo: step2. 주기 데이터를 전달받음

        for(Gps gps : gpses) {
            System.out.printf("(%d, %d) \t", gps.getLatitude(), gps.getLongitude());
        }

        System.out.println();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/off/{emulatorId}")
    public ResponseEntity<String> off(@PathVariable(value = "emulatorId") Long emulatorId) {
        log.info("Off => input emulatorId: {}", emulatorId);
        emulatorService.turnOff(emulatorId);
        //todo: 스케줄러 중단

        return ResponseEntity.ok("%d번 애뮬레이터가 종료되었습니다.".formatted(emulatorId));
    }
}
