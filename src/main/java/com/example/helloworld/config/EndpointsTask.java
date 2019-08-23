package com.example.helloworld.config;

import com.google.common.collect.ImmutableMultimap;
import io.dropwizard.jersey.DropwizardResourceConfig;
import io.dropwizard.servlets.tasks.Task;


import java.io.PrintWriter;

public class EndpointsTask extends Task {
    public EndpointsTask() {
        super("endpoints");
    }
    @Override
    public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output)
            throws Exception {
        DropwizardResourceConfig config = new DropwizardResourceConfig();
        config.packages("com.example.helloworld.api");
        output.println(config.getEndpointsInfo());
    }
}
