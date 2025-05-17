package com.practice.emulator.model.dto.response;

import java.time.LocalDateTime;

//fixme: 멀티 모듈시 동일한게 2개?
public record GpsDataResponse(
        String longitude,
        String latitude,
        LocalDateTime timestamp
) {
}
