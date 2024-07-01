package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {

        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") long courseId) {

        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {

        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseId, course);
    }
@DeleteMapping("{id}")
    public void deleteCourse(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
}
}
