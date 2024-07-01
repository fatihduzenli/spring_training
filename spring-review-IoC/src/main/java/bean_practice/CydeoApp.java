package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AppConfig1.class);

        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);
        PartTimeEmployee partTimeEmployee = context.getBean(PartTimeEmployee.class);
        String s = context.getBean("huu",String.class);
        String s1 = context.getBean("huu1",String.class);
        System.out.println(s);
        System.out.println(s1);

        fullTimeEmployee.createAccount();
        partTimeEmployee.createAccount();
    }
}
