package com.example.TEP13.Backend.Application.config;
import com.example.TEP13.Backend.Application.api.userEndPoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(userEndPoint.class);
    }
}


