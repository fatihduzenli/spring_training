package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model) {
        model.addAttribute("name", "Cydeo");

        model.addAttribute("course", "MVC");

        String subject = "Spring Boot";
        model.addAttribute("subject", subject);

        int studentId = new Random().nextInt();
        model.addAttribute("studentId", studentId);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(90);
        model.addAttribute("numbers", list);

        LocalDateTime dateTime= LocalDateTime.now();
        model.addAttribute("dateAndTime",dateTime);

        Student student=new Student(1,"Fatih","Duzenli");
        model.addAttribute("student",student);


        return "student/welcome";  // when we use template, we don't use .html
    }
}
