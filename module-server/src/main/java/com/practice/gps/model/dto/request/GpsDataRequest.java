package com.practice.gps.model.dto.request;

import java.time.LocalDateTime;

public record GpsDataRequest(
        Long emulatorId,
        Double longitude,
        Double latitude,
        LocalDateTime timestamp
) {
}
