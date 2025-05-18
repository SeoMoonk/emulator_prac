package com.practice.gps.service;

import com.practice.gps.model.entity.Gps;
import com.practice.gps.repository.GpsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class GpsService {

    private final GpsRepository gpsRepository;

    @Transactional
    public void saveAll(Queue<Gps> gpsQueue) {
        List<Gps> list = gpsQueue.stream().toList();
        gpsRepository.saveAll(list);
    }

}
