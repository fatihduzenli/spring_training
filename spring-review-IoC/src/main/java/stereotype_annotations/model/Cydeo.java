package stereotype_annotations.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.ConfigAppNew;

public class Cydeo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAppNew.class);
        DataStructure dataStructure = context.getBean(DataStructure.class);
        Microservice microservice = context.getBean(Microservice.class);
        dataStructure.getTotalHours();
        microservice.getTotalHours();
    }
}
