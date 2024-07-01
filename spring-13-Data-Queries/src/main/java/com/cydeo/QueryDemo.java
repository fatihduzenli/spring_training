package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;


    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("findByCountry"+regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining"+regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc"+regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTopByCountry"+regionRepository.findTop2ByCountry("United States"));
        System.out.println("findByCountryContainingOrderByRegion"+regionRepository.findTopByCountryContainsOrderByRegion("United"));

        System.out.println("----------------Department-----------------");
        System.out.println("findByDepartment"+departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision"+departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionContaining"+departmentRepository.findByDivisionEndingWith("ics"));
        System.out.println("findTopByCountryContainsOrderByRegion"+departmentRepository.findDistinctTop3ByDivisionContains("Hea"));


        System.out.println("-------------Employee-------------------");

        System.out.println(employeeRepository.retrieveEmployeeDetail());
        System.out.println(employeeRepository.retrieveEmployeeSalary());
    }
}
