package com.claudioliveira.domain.event;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by claudio on 02/09/16.
 */
public class DeviceTemperatureMeasure {

    @Getter
    private final LocalDateTime measureAt = LocalDateTime.now();

    @Getter
    private final Double value;

    public DeviceTemperatureMeasure(Double value) {
        this.value = value;
    }

}
