package com.practice.receiver.controller;

import com.practice.gps.model.dto.request.GpsDataRequest;
import com.practice.receiver.service.ReceiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reciever")
@RequiredArgsConstructor
public class RecieverRestController {

    private final ReceiverService receiverService;

    @PostMapping("/recieve")
    public void recieve(@RequestBody GpsDataRequest request) {
        receiverService.save(request);
    }

    @PostMapping("/off-save/{emulatorId}")
    public void offSave(@PathVariable(value = "emulatorId") Long emulatorId) {
        receiverService.sendByOffCall(emulatorId);
    }
}
