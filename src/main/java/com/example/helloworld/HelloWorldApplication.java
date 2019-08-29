package com.example.helloworld;

import com.example.helloworld.DAO.InfoDao;
import com.example.helloworld.api.EmployeeController;
import com.example.helloworld.api.MyResource;
import com.example.helloworld.model.Employee;
import com.example.helloworld.model.Info;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.DropwizardResourceConfig;
import io.dropwizard.servlets.tasks.Task;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.api.HelloWorldResource;
import com.example.helloworld.health.TemplateHealthCheck;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import jersey.repackaged.com.google.common.collect.ImmutableMultimap;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import java.io.PrintWriter;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }



    private HibernateBundle<HelloWorldConfiguration> hibernateBundle = new HibernateBundle<HelloWorldConfiguration>(Info.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(
                HelloWorldConfiguration configuration
        ) {
            return configuration.getDataSourceFactory();
        }

    };


    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new SwaggerBundle<HelloWorldConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(HelloWorldConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final EmployeeController employeeController = new EmployeeController();
        environment.jersey().register(employeeController);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        InfoDao infoDao = new InfoDao(hibernateBundle.getSessionFactory());
        final MyResource resource1 = new MyResource(infoDao);
        environment.jersey().register(resource1);


    }


}
