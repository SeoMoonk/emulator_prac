package com.practice.gps.controller;

import com.practice.gps.model.entity.Gps;
import com.practice.gps.service.GpsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RequestMapping("/api/v1/gps")
@RestController
@RequiredArgsConstructor
public class GpsRestController {

    private final GpsService gpsService;

    public GpsRestController(GpsService gpsService) {
        this.gpsService = gpsService;
    }

    @PostMapping("/save")
    public void save(@RequestBody Queue<Gps> gpsDataList) {
        gpsService.saveAll(gpsDataList);
    }
}
