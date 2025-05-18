package com.practice.gps.model.entity;

import com.practice.gps.model.dto.request.GpsDataRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;

    private LocalDateTime timestamp;

    public Gps(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = LocalDateTime.now();
    }

    public static Gps toEntity(GpsDataRequest request) {
        return Gps.builder()
                .latitude(request.latitude())
                .longitude(request.longitude())
                .timestamp(request.timestamp())
                .build();
    }
}
