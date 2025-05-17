package com.practice.emulator.model.entity;


import com.practice.emulator.model.dto.response.GpsDataResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gps {
    Double latitude;
    Double longitude;
    LocalDateTime timestamp;

    public Gps(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = LocalDateTime.now();
    }

    public static Gps toEntity(GpsDataResponse response) {
        return Gps.builder()
                .latitude(Double.parseDouble(response.latitude().trim()))
                .longitude(Double.parseDouble(response.longitude().trim()))
                .timestamp(response.timestamp())
                .build();
    }

    public static Gps move(Gps gps) {
        return new Gps(gps.latitude + 1, gps.longitude + 1);
    }
}
