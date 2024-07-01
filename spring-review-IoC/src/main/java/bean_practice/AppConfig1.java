package bean_practice;

import org.springframework.context.annotation.Bean;

public class AppConfig1 {
    @Bean("huu")
    public String hello(){
        return "Welcome to Cydeo";
    }
    @Bean("huu1")
    public String practice(){
        return "Spring Core Project";
    }
}
