package com.claudioliveira.domain.repository.impl;

import com.claudioliveira.domain.Temperature;
import com.claudioliveira.domain.event.DeviceTemperatureMeasure;
import com.claudioliveira.domain.repository.TemperatureRepository;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by claudio on 02/09/16.
 */
@ApplicationScoped
public class CacheTemperatureRepository implements TemperatureRepository {

    private final Cache<String, TreeSet<Temperature>> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(24L, TimeUnit.HOURS).build();

    @Override
    public Temperature add(DeviceTemperatureMeasure deviceTemperatureMeasure) {
        final String hour = String.valueOf(deviceTemperatureMeasure.getMeasureAt().getHour());
        final String uuid = UUID.randomUUID().toString();
        final Temperature newTemperature = new Temperature(uuid, deviceTemperatureMeasure.getMeasureAt(), deviceTemperatureMeasure.getValue());
        TreeSet<Temperature> temperatures = this.cache.getIfPresent(hour);
        if (Objects.nonNull(temperatures)) {
            temperatures.add(newTemperature);
        } else {
            temperatures = new TreeSet<>();
        }
        this.cache.put(hour, temperatures);
        return newTemperature;
    }

    @Override
    public Set<Temperature> temperaturesPerHour(String hour){
        return this.cache.getIfPresent(hour);
    }

}
