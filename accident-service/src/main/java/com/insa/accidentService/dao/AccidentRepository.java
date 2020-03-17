package com.insa.accidentService.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.insa.accidentService.entities.Accident;

/**
 * 
 * @author Nicolas
 *
 */

@RepositoryRestResource
public interface AccidentRepository extends JpaRepository<Accident,Integer> {
}
