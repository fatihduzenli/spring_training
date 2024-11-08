package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean(name = "sony")
    @Primary
public Monitor monitorSony(){

    return new SonyMonitor("25 inch Beast","Acer",25);
}
@Bean
public Motherboard AsusMotherBoard(){
        return new AsusMotherboard("BJ-200","Asus",4,6,"V2.44");
}
@Bean
public Case DellCase(){
        return new DellCase("wow","Dell","240");
}

}
