package com.example.Config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ProjectConfig {

    @Bean(name = "audi")
    Vehicle  vehicle(){
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return  veh;
    }

    @Bean(name = "honda")
    Vehicle  vehicle2(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return  veh;
    }

    @Primary
    @Bean(name = "ferrari")
    Vehicle  vehicle3(){
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return  veh;
    }

}
