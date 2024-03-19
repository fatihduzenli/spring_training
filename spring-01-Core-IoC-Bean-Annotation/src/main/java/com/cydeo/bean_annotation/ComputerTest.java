package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {


        System.out.println("Creating Container");

        //Creating container by using Application Context(Container)
        // Context = Container

        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerTest.class, RandomConfig.class);

        //Configuration means adding beans into context, We pass the config class in the Constructor

        Monitor theMonitor=container.getBean(Monitor.class);
        // this is how we get the monitor object inside the container

        Case theCase=container.getBean(Case.class);
        Motherboard theMotherboard=container.getBean(Motherboard.class);

        PC myPc= new PC(theCase,theMonitor,theMotherboard);
        myPc.powerUp();









    }
}
