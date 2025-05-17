package com.practice.emulator.controller;

import com.practice.emulator.model.dto.response.GpsDataResponse;
import com.practice.emulator.model.entity.Gps;
import com.practice.emulator.service.EmulatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmulatorEventScheduler {

    private static final Integer TRANSMISSION_PERIOD = 10;

    private final EmulatorService emulatorService;
    private final RestClient restClient = RestClient.create();
    private final Map<Long, Queue<Gps>> queues = new HashMap<>();

    @Scheduled(fixedDelay = 1000)
    public void traffic() {
        List<Long> runningIds = emulatorService.getRunningIds();

        System.out.println("runningIds = " + runningIds);

        for (Long emulatorId : runningIds) {
            Queue<Gps> queue = queues.computeIfAbsent(emulatorId,
                    id -> new LinkedList<>());

            Gps gps = requestGpsData(emulatorId);
            queue.add(gps);

            if (queue.size() >= TRANSMISSION_PERIOD) {
                sendGpsData(emulatorId, new ArrayList<>(queue));
                queue.clear();
            }
        }
    }

    private Gps requestGpsData(Long emulatorId) {
        GpsDataResponse response = restClient.get()
                .uri("http://localhost:8081/api/v1/gps/data")
                .retrieve()
                .body(GpsDataResponse.class);

        System.out.println(response.toString());

        return Gps.toEntity(response); // 변환 메서드 사용
    }

    private void sendGpsData(Long emulatorId, List<Gps> gpsList) {
        restClient.post()
                .uri("http://localhost:8080/api/v1/emulator/receive")
                .contentType(MediaType.APPLICATION_JSON)
                .body(gpsList)
                .retrieve()
                .toBodilessEntity();
    }
}
