package com.example.main;

import com.example.Config.ProjectConfig;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class example2 {
    public static void main(String[] args) {


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean("vehicle",Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + veh.getName());

        Vehicle veh2 = context.getBean("vehicle2",Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + veh2.getName());
    }
}
