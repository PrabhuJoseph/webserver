package com.sample.web;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ws/v1/sample")
public class WebService {

    public static final String UTF_8 = "charset=utf-8";

    @GET
    @Produces({ MediaType.APPLICATION_JSON + "; " + UTF_8,
            MediaType.APPLICATION_XML + "; " + UTF_8 })
    public VersionInfo version() {
        return new VersionInfo("CDP-7.1.0");
    }

}
