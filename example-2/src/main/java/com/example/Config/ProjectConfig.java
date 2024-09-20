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
    Vehicle  vehicle2(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return  veh;
    }

    @Bean
    Vehicle  vehicle3(){
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return  veh;
    }

}
