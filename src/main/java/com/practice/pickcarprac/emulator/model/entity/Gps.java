package com.practice.pickcarprac.emulator.model.entity;


import com.practice.pickcarprac.emulator.model.dto.response.GpsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gps {
    Integer latitude;
    Integer longitude;
    LocalDateTime timestamp;

    public static Gps toEntity(GpsData gpsData) {
        return new Gps(gpsData.latitude(), gpsData.longitude(), LocalDateTime.now());
    }

    public Gps(Integer latitude, Integer longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = LocalDateTime.now();
    }

    public static Gps move(Gps gps) {
        return new Gps(gps.latitude + 1, gps.longitude + 1);
    }
}
