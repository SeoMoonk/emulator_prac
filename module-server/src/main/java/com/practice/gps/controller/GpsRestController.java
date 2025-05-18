package com.practice.gps.controller;

import com.practice.gps.model.entity.Gps;
import com.practice.gps.service.GpsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@Slf4j
@RequestMapping("/api/v1/gps")
@RestController
@RequiredArgsConstructor
public class GpsRestController {

    private final GpsService gpsService;

    @PostMapping("/save")
    public void save(@RequestBody Queue<Gps> gpsDataList) {
        log.info("Gps Data List : {}", gpsDataList);
        gpsService.saveAll(gpsDataList);
    }
}
