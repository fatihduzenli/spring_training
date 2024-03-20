package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.PcConfig;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.monitorfactory.SonyMonitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext context =new AnnotationConfigApplicationContext(PcConfig.class);

        Monitor theMonitor= context.getBean(Monitor.class);
        System.out.println(theMonitor.getSize());
    }
}
