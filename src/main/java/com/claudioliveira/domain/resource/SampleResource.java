package com.claudioliveira.domain.resource;

import com.claudioliveira.domain.event.DeviceData;
import com.claudioliveira.domain.event.DeviceHumidityMeasure;
import com.claudioliveira.domain.event.DeviceTemperatureMeasure;
import com.claudioliveira.domain.service.DeviceDataNotifier;
import lombok.extern.java.Log;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;

/**
 * Created by claudio on 05/09/16.
 */
@Path("/sample")
@Log
public class SampleResource {

    @Inject @Any
    private DeviceDataNotifier deviceDataNotifierDummy;

    @POST
    @Path("/data")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response temperature() {
        log.info("========== New Measure (Sample Data) ==========");
        Random r = new Random();
        final DeviceTemperatureMeasure deviceTemperatureMeasure = new DeviceTemperatureMeasure(r.nextDouble());
        final DeviceHumidityMeasure deviceHumidityMeasure = new DeviceHumidityMeasure(r.nextDouble());
        final DeviceData deviceData = new DeviceData(deviceHumidityMeasure, deviceTemperatureMeasure);
        this.deviceDataNotifierDummy.notifyNewTemperature(deviceData);
        return Response.ok(deviceData).build();
    }

}
