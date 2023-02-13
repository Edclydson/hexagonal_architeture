package com.example.hexagonal.config;

import com.example.hexagonal.adapters.outbound.GetAddressAdapter;
import com.example.hexagonal.adapters.outbound.SaveUserAdapter;
import com.example.hexagonal.application.core.service.SaveUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config{

    @Bean
    public SaveUserService saveUserService(SaveUserAdapter saveUserAdapter, GetAddressAdapter getAddressAdapter){
        return new SaveUserService(saveUserAdapter, getAddressAdapter);
    }
}
