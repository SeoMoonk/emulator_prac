package com.practice.gps.model.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GpsDataResponse(
        String longitude,
        String latitude,
        LocalDateTime timestamp
) {
}
