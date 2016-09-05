package com.claudioliveira.domain.service;

import com.claudioliveira.domain.event.DeviceData;

/**
 * Created by claudio on 05/09/16.
 */
public interface BusDataNotifier {

    void send(DeviceData deviceData);

}
