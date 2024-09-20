package com.example.main;

import com.example.Config.ProjectConfig;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class example1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda city");
        System.out.println("Vehicle name from non-spring Context name: " + vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from spring context is: " + veh.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value from spring context is: "+hello);
        Integer number = context.getBean(Integer.class);
        System.out.println("Integer value from spring context is: " + number);
    }
}
