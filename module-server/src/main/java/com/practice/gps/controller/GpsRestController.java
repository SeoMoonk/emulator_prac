package com.practice.gps.controller;

import com.practice.gps.model.entity.Gps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RestController
@RequestMapping("/api/v1/gps")
@Slf4j
public class GpsRestController {

    @PostMapping("/save")
    public void save(@RequestBody Queue<Gps>gpsDataList) {
        System.out.println("데이터를 받았습니다");

        log.info("Gps Data List : {}", gpsDataList);
    }
}
