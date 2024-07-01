package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    //Display all the regions in Canada
    List<Region>findByCountry(String country);
    List<Region>getByCountry(String country);  // get and find is same

    // Display all the regions with country name includes 'United'

    List<Region>findByCountryContaining(String country);


// display all the regions with country names includes 'United' in order(regions)
List<Region>findByCountryContainsOrderByRegionDesc(String country);

// display top 2 regions in UnitedStates
    List<Region>findTopByCountry(String country);
    List<Region>findTop2ByCountry(String country);

    // we collect all the queries above in one query

    List<Region>findTopByCountryContainsOrderByRegion(String country);




}
