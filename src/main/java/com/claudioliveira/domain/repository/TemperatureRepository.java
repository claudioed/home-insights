package com.claudioliveira.domain.repository;

import com.claudioliveira.domain.Temperature;
import com.claudioliveira.domain.event.DeviceTemperatureMeasure;

import java.util.Set;

/**
 * Created by claudio on 02/09/16.
 */
public interface TemperatureRepository {

    Temperature add(DeviceTemperatureMeasure deviceTemperatureMeasure);

    Set<Temperature> temperaturesPerHour(String hour);

}
