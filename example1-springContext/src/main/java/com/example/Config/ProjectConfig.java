package com.example.Config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;

public class ProjectConfig {

    @Bean
    Vehicle  vehicle(){
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return  veh;
    }

    @Bean
    String Hello(){
        return "hello";
    }

    @Bean
    Integer number(){
        return 15;
    }
}
