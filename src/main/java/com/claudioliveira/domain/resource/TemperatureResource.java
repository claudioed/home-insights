package com.claudioliveira.domain.resource;

import com.claudioliveira.domain.repository.impl.CacheTemperatureRepository;

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
@Path("/temperature")
public class TemperatureResource {

    @Inject
    private CacheTemperatureRepository temperatureRepository;

    @GET
    @Path("/hour/{hour}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response temperaturesByHour(@PathParam("hour")String hour){
        return Response.ok(this.temperatureRepository.temperaturesPerHour(hour)).build();
    }

}
