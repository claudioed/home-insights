package com.claudioliveira.domain.resource;

import com.claudioliveira.domain.repository.HumidityRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by claudio on 05/09/16.
 */
@Path("/humidity")
public class HumidityResource {

    @Inject
    private HumidityRepository humidityRepository;

    @GET
    @Path("/humidity/{hour}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response temperaturesByHour(@PathParam("hour")String hour){
        return Response.ok(this.humidityRepository.humidityPerHour(hour)).build();
    }

}
