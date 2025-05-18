package com.practice.gps.repository;

import com.practice.gps.model.entity.Gps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpsRepository extends JpaRepository<Gps, Long> {
}
