package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
       return ResponseEntity
               .status(HttpStatus.ACCEPTED)
               .header("Version","Cydeo.V2")
               .header("Operation","Get List")
               .body(courseService.getCourses());

    }
@GetMapping("{id}")
  public  ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long courseId){

        return ResponseEntity.ok(courseService.getCourseById(courseId));
}
@GetMapping("category/{categoryName}")
   private ResponseEntity<List<CourseDTO>>getByCategoryName(@PathVariable("categoryName") String name){
        return ResponseEntity.ok(courseService.getCoursesByCategory(name));
}
@PostMapping
  public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course));
  }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

 @PutMapping("{id}")
    public  ResponseEntity<Void> updateById(@PathVariable("id") Long id,@RequestBody CourseDTO course){

        courseService.updateCourse(id,course);
        return ResponseEntity.noContent().build();
        //  NO_CONTENT(204, HttpStatus.Series.SUCCESSFUL, "No Content"),

    }


}
