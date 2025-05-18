package com.practice.receiver.service;

import com.practice.gps.model.dto.request.GpsDataRequest;
import com.practice.gps.model.entity.Gps;
import com.practice.receiver.repository.InMemoryGpsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Queue;

@Service
@RequiredArgsConstructor
public class ReceiverService {

    private static final Integer MAX_SIZE = 60;

    private final InMemoryGpsRepository inMemoryGpsRepository;
    private final RestClient restClient = RestClient.create();

    public void save(GpsDataRequest request) {
        Queue<Gps> current = inMemoryGpsRepository.save(request.emulatorId(), Gps.toEntity(request));

        System.out.println("데이터 쌓는중 ... => " + current.size());

        if(current.size() == MAX_SIZE) {
            sendToMain(request.emulatorId(), current);
            inMemoryGpsRepository.clearById(request.emulatorId());
        }
    }

    public void sendToMain(Long emulatorId, Queue<Gps> current) {

        System.out.println("데이터를 보낼게요!!");

        restClient.post()
                .uri("http://localhost:8082/api/v1/gps/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(current)
                .retrieve()
                .toBodilessEntity();

        inMemoryGpsRepository.clearById(emulatorId);
    }
}
