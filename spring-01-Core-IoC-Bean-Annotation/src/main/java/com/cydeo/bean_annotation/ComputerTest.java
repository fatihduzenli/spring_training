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
        // Creating container by using beanFactory
        BeanFactory context = new AnnotationConfigApplicationContext();

        //Configuration means adding beans into context, We pass the config class in the Constructor

        System.out.println("************Retrieving the beans******************");

        Case theCase=container.getBean(Case.class);  // here we are calling a necessity object from the container
        Motherboard theMotherboard=container.getBean(Motherboard.class); // here we are calling a necessity object from the container

        System.out.println("************Multiple Objects******************");

        Monitor theMonitor=container.getBean(Monitor.class); // here we are calling a necessity object from the container
        // this is how we get the monitor object inside the container

        Monitor theMonitor2 = container.getBean("sony", Monitor.class);
        // We can specify the object by giving it a name

        Monitor theMonitor3 = container.getBean(Monitor.class); //Primary
        // if we pass @primary annotation for bean method, that would be the fist object to call



        PC myPc= new PC(theCase,theMonitor,theMotherboard);
        myPc.powerUp();









    }
}
