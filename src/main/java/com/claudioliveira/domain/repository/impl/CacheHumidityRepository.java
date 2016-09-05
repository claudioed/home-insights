package com.claudioliveira.domain.repository.impl;

import com.claudioliveira.domain.Humidity;
import com.claudioliveira.domain.event.DeviceHumidityMeasure;
import com.claudioliveira.domain.repository.HumidityRepository;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by claudio on 02/09/16.
 */
@ApplicationScoped
public class CacheHumidityRepository implements HumidityRepository {

    private final Cache<String, TreeSet<Humidity>> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(24L, TimeUnit.HOURS).build();

    @Override
    public Humidity add(DeviceHumidityMeasure deviceHumidityMeasure) {
        final String uuid = UUID.randomUUID().toString();
        final String hour = String.valueOf(deviceHumidityMeasure.getMeasureAt().getHour());
        final Humidity newHumidity = new Humidity(uuid, deviceHumidityMeasure.getMeasureAt(), deviceHumidityMeasure.getValue());
        TreeSet<Humidity> humidities = this.cache.getIfPresent(hour);
        if(Objects.nonNull(humidities)){
            humidities.add(newHumidity);
        }else {
            humidities = new TreeSet<>();
        }
        this.cache.put(hour, humidities);
        return newHumidity;
    }

    @Override
    public Set<Humidity> humidityPerHour(String hour) {
        return this.cache.getIfPresent(hour);
    }

}
