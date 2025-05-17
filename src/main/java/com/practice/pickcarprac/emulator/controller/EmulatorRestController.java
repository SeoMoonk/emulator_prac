package com.practice.pickcarprac.emulator.controller;

import com.practice.pickcarprac.emulator.service.EmulatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emulator")
public class EmulatorRestController {

    private final EmulatorService emulatorService;

    public EmulatorRestController(EmulatorService emulatorService) {
        this.emulatorService = emulatorService;
    }

    @PostMapping("/on")
    public void on() {
        //Todo: step1. 시동이 켜짐
    }

    @PostMapping("/receive")
    public void receive() {
        //Todo: step2. 주기 데이터를 전달받음
    }

    @PostMapping("/off")
    public void off() {
        //Todo: step3. 시동이 꺼짐
    }
}
