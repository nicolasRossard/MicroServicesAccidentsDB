package com.insa.victimService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.insa.victimService.entities.Victim;

@RepositoryRestResource
public interface VictimRepository extends JpaRepository<Victim,Integer>{

}
