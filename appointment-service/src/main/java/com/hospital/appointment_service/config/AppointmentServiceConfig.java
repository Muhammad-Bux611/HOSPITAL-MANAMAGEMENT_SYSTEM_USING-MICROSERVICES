package com.hospital.appointment_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppointmentServiceConfig {

    @Bean
    public RestClient client(){
        return RestClient.create();
    }

}
