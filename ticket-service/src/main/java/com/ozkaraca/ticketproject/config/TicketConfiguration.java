package com.ozkaraca.ticketproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.ozkaraca.ticketproject")
//@EnableElasticsearchRepositories
@ComponentScan("com.ozkaraca.ticketproject")
public class TicketConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
