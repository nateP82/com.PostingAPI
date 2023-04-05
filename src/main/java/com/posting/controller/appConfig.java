package com.posting.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;
import com.posting.resource.*;

@ApplicationPath("/comPosting/")
public class appConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(servicesV1.class);
        h.add(servicesV2.class);
        return h;
    }
}
