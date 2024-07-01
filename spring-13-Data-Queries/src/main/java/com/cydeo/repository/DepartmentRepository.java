package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    // display all the departments in the furniture department

    List<Department>findByDepartment(String department);

    //Display all the departments in the health division

    List<Department>findByDivision(String division);
    List<Department>findByDivisionIs(String division);
    List<Department>findByDivisionEquals(String division);

    //Display all the departments with the division name ends with 'ics'

    List<Department>findByDivisionEndingWith(String division);

    // Display top 3 departments with division name include 'Hea' without duplicates

    List<Department>findDistinctTop3ByDivisionContains(String lolo);

    @Query("select d from Department d where d.division IN ?1")
    List<Department>retrieveDepartmentDivision(List<String> division);



}
