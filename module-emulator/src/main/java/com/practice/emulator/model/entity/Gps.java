package com.practice.emulator.model.entity;


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
    Double latitude;
    Double longitude;
    LocalDateTime timestamp;

    public Gps(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = LocalDateTime.now();
    }

    public static Gps move(Gps gps) {
        return new Gps(gps.latitude + 1, gps.longitude + 1);
    }
}
