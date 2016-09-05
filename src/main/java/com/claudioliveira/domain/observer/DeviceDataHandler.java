package com.claudioliveira.domain.observer;

import com.claudioliveira.domain.event.DeviceData;
import com.claudioliveira.domain.repository.HumidityRepository;
import com.claudioliveira.domain.repository.TemperatureRepository;
import com.claudioliveira.domain.service.BusDataNotifier;
import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * Created by claudio on 02/09/16.
 */
@ApplicationScoped
@Log
public class DeviceDataHandler {

    @Inject
    private TemperatureRepository temperatureRepository;

    @Inject
    private HumidityRepository humidityRepository;

    @Inject
    private BusDataNotifier busDataNotifier;

    public void handleTemperatureMeasure(@Observes DeviceData deviceData){
        log.info("========== New Measure ==========");
        this.temperatureRepository.add(deviceData.getDeviceTemperatureMeasure());
        this.humidityRepository.add(deviceData.getDeviceHumidityMeasure());
        this.busDataNotifier.send(deviceData);
    }

}