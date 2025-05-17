package com.practice.gps.controller;

import com.practice.gps.model.response.GpsDataResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/gps")
public class GpsRestController {

    //fixme: mapping 수정 필요

    @GetMapping("/data")
    public ResponseEntity<GpsDataResponse> getGpsData(HttpServletRequest request) {

        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        
        // fixme: https 환경에서, geolocation을 사용해야 사용자의 위도, 경도를 받을 수 있음. 일단 ip 주소로 임의로 진행
        GpsDataResponse response = GpsDataResponse.builder()
                .latitude(request.getRemoteAddr().substring(0, 5))
                .longitude(request.getRemoteAddr().substring(0, 5))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }
}
