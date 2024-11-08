package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    // find all courses by category

   List<Course>findByCategory(String category);

   // Find all courses by category and order the entities by name

    List<Course>findByCategoryOrderByName(String category);

    // Checks if a course with the supplied name exists.Return true if exists false otherwise


  boolean existsByName(String name);

  // Returns the count of courses for the given category

    int countByCategory(String category);

    //Finds all the courses that start with the given course name string
    List<Course> findByNameStartingWith(String name);

    //Find all courses by category and returns a stream
    Stream<Course>streamAllByCategory(String category);



    @Query("select c from Course c where c.category = : catagory and c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);



}
