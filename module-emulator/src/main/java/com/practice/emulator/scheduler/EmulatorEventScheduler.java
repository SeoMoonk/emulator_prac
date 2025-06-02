package com.practice.emulator.scheduler;

import com.practice.emulator.model.dto.request.GpsDataRequest;
import com.practice.emulator.service.EmulatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmulatorEventScheduler {

    private final EmulatorService emulatorService;
    private final RestClient restClient = RestClient.create();

    @Scheduled(fixedDelay = 1000)
    public void send() {
        List<Long> runningIds = emulatorService.getRunningIds();

        for (Long emulatorId : runningIds) {
            GpsDataRequest request = new GpsDataRequest(emulatorId, generateRandomLat(), generateRandomLon(), LocalDateTime.now());
            restClient.post()
                    .uri("http://localhost:8081/api/v1/reciever/recieve")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .toBodilessEntity();
        }
    }

    public static double generateRandomLat() {
        return ThreadLocalRandom.current().nextDouble(-90.0, 90.0);
    }

    public static double generateRandomLon() {
        return ThreadLocalRandom.current().nextDouble(-180.0, 180.0);
    }

//    private Gps requestGpsData(Long emulatorId) {
//        GpsDataResponse response = restClient.get()
//                .uri("http://localhost:8081/api/v1/gps/data")
//                .retrieve()
//                .body(GpsDataResponse.class);
//
//        System.out.println(response.toString());
//
//        return Gps.toEntity(response); // 변환 메서드 사용
//    }
}
