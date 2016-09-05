package com.claudioliveira.domain.event;

import lombok.Getter;

/**
 * Created by claudio on 05/09/16.
 */
public class DeviceData {

    @Getter
    private final DeviceHumidityMeasure deviceHumidityMeasure;

    @Getter
    private final DeviceTemperatureMeasure deviceTemperatureMeasure;

    public DeviceData(DeviceHumidityMeasure deviceHumidityMeasure, DeviceTemperatureMeasure deviceTemperatureMeasure) {
        this.deviceHumidityMeasure = deviceHumidityMeasure;
        this.deviceTemperatureMeasure = deviceTemperatureMeasure;

    }

}
