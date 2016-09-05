package com.claudioliveira.domain.service.impl;

import com.claudioliveira.domain.event.DeviceData;
import com.claudioliveira.domain.service.BusDataNotifier;
import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by claudio on 05/09/16.
 */
@ApplicationScoped
@Log
public class KafkaDataNotifier implements BusDataNotifier {

    @Override
    public void send(DeviceData deviceData) {
        log.info("============= Send data to Kafka =============");
    }

}
