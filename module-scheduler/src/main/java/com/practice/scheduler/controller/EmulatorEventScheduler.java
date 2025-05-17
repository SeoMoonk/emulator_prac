//package com.practice.scheduler.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestClient;
//
//import java.util.*;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class EmulatorEventScheduler {
//
//    private static final Integer TRANSMISSION_PERIOD = 10;
//    private final RestClient restClient = RestClient.create();
//    private final Map<Long, PriorityQueue<Gps>> queues = new HashMap<>();
//
//    @Scheduled(fixedDelay = 1000)
//    public void traffic() {
//
//        for (Long id : emulatorService.getRunningIds()) {
//            log.info("%d번은 지금 돌아가는중!".formatted(id));
//
//            PriorityQueue<Gps> queue = queues.getOrDefault(id, new PriorityQueue<>(Comparator.comparing(Gps::getTimestamp)));
//            queues.putIfAbsent(id, queue);
//
//            if (queue.isEmpty()) {
//                queue.add(Gps.toEntity(new GpsData(10, 20)));
//                continue;
//            }
//
//            queue.add(Gps.move(queue.peek()));
//
//            System.out.println(queue);
//
//            if (queue.size() == TRANSMISSION_PERIOD) {
//                restClient.post()
//                        .uri("http://localhost:8080/api/v1/emulator/receive")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(new ArrayList<>(queue))
//                        .retrieve()
//                        .body(Map.class);
//
//                queues.replace(id, new PriorityQueue<>(Comparator.comparing(Gps::getTimestamp)));
//                continue;
//            }
//
//            queues.replace(id, queue);
//        }
//    }
//}
