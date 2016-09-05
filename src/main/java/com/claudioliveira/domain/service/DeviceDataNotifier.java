package com.claudioliveira.domain.service;

import com.claudioliveira.domain.event.DeviceData;
import com.claudioliveira.domain.event.DeviceTemperatureMeasure;

/**
 * Created by claudio on 02/09/16.
 */
public interface DeviceDataNotifier {

    void notifyNewTemperature(DeviceData deviceData);

}
