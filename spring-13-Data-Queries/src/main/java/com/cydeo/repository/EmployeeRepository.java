package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // display all the employees with their email address

    List<Employee> findByEmail(String email);

    // DISPLAY ALL THE EMPLOYEES WITH FIRSTNAME " " AND LASTNAME " ",
    // ALSO SHOW ALL EMPLOYEES WITH EMAIL ADDRESS

    List<Employee> findByFirstNameAndLastNameOrEmail(String name, String lastname, String email);


    //Display all the employees that first name is not "";

    List<Employee> findByFirstNameIsNot(String name);

    // display all employees that last name starts with ""

    List<Employee> findByLastNameStartingWith(String name);

    // Display all the employees with salary higher than''

    List<Employee> findBySalaryIsGreaterThan(Integer salary);

    // Display all the employees with salaries less then

    List<Employee> findBySalaryIsLessThan(Integer salary);

    //Display all employees that have been hired between '' and ''

    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all the employee that salaries greater and equal to '' in order

    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top unique 3 employees that are making less than ''

    List<Employee> findDistinctTop3BySalaryIsLessThan(Integer salary);


    //Display all employees that do not have email address
    //  List<Employee>findByEmailIsNull(String email);

    // ---------------JPQL QUERY----------------//
    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();


    @Query("SELECT e.salary from Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

    //Not equal
    @Query("SELECT e from Employee e where e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);


    //Like / contains/startWith/EndsWith

    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);


    // Less Than
    @Query("select e from Employee e where e.salary <?1")
    List<Employee> retrieveEmployeeLessThan(int salary);

    @Query("select e.firstName from Employee e where e.salary <?1")
    List<String> retrieveEmployeeAndPrintFistNameLessThan(int salary);


    //Between

    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);


    // before
    @Query("select e from Employee e WHERE e.hireDate >?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //Null
    @Query("SELECT e from Employee e WHERE e.email is NOT NULL ")
    List<Employee> retrieveEmployeeEmailIsNull();


    // SORTING IN ASC ORDER
    @Query("select e FROM Employee e order by e.salary ASC ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();


    // -----------NATIVE QUERY--------------//
@Query(value = "SELECT *from employees where salary=?1",nativeQuery = true)
    List<Employee>retrieveEmployeeDetailBySalary(int salary);

//---------NAMED PARAMETER------------//

    @Query("select e from Employee e where e.salary= :salary")
    List<Employee>retrieveEmployeeSalary(@Param("salary") int salary);




}
