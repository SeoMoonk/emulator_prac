package com.practice.receiver.repository;

import com.practice.gps.model.entity.Gps;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Component
public class InMemoryGpsRepository {

    private final Map<Long, Queue<Gps>> repository = new HashMap<>();

    public Queue<Gps> save(Long emulatorId, Gps gps) {
        Queue<Gps> emulatorQueue = repository.computeIfAbsent(emulatorId, id -> new LinkedList<>());
        emulatorQueue.add(gps);

        return repository.put(emulatorId, emulatorQueue);
    }

    public Queue<Gps> findById(Long emulatorId) {
        return repository.getOrDefault(emulatorId, new LinkedList<>());
    }

    public void clearById(Long key) {
        repository.remove(key);
    }

    public int countById(Long key) {
        return repository.getOrDefault(key, new LinkedList<>()).size();
    }
}
