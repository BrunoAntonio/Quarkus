package org.acme;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api")
public class LongServiceResource {

    @Inject
    LongService service;

    @GET
    @Path("/blocking")
    @Blocking
    public String getLongBlockingService() throws InterruptedException {
        return service.serviceTime();
    }

    @GET
    @Path("/nonblocking")
    @NonBlocking
    public String getLongBlockingServiceUni() throws InterruptedException {
        return service.serviceTimeUni();
    }
}