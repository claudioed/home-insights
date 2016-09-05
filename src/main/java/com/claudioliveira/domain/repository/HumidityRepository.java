package com.claudioliveira.domain.repository;

import com.claudioliveira.domain.Humidity;
import com.claudioliveira.domain.event.DeviceHumidityMeasure;

import java.util.Set;

/**
 * Created by claudio on 02/09/16.
 */
public interface HumidityRepository {

    Humidity add(DeviceHumidityMeasure deviceHumidityMeasure);

    Set<Humidity> humidityPerHour(String hour);

}
