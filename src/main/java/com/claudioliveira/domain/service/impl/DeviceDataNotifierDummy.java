package com.claudioliveira.domain.service.impl;

import com.claudioliveira.domain.event.DeviceData;
import com.claudioliveira.domain.event.DeviceHumidityMeasure;
import com.claudioliveira.domain.event.DeviceTemperatureMeasure;
import com.claudioliveira.domain.service.DeviceDataNotifier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by claudio on 02/09/16.
 */
@ApplicationScoped
public class DeviceDataNotifierDummy implements DeviceDataNotifier {

    @Inject
    private Event<DeviceData> newMeasure;

    @Override
    public void notifyNewTemperature(DeviceData deviceData) {
        this.newMeasure.fire(deviceData);
    }

}
