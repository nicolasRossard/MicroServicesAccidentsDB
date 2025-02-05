package com.insa.accidentService.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.insa.accidentService.dao.AccidentRepository;
import com.insa.accidentService.entities.*;
import com.insa.accidentService.web.exceptions.AccidentAddException;
import com.insa.accidentService.web.exceptions.AccidentNotFoundException;
import com.insa.accidentService.web.exceptions.AccidentToDeleteNotFound;
import com.insa.accidentService.web.exceptions.AccidentUpdateException;

//import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller which communicates with Accident DB
 * INFORMATION
 * JPARepository is created. It's possible to use JPAPreository and all functions which are
 * already implemented by using url: LocalHost...../accidents (accidents without CAPS)
 * this controller is made manually to use what we saw in class
 * @author Nicolas
 *
 */
@RefreshScope
/* localhost:8081/actuator/..... */
@RestController
public class AccidentController {
	@Autowired
	private AccidentRepository accidentRepository;
	
	
	/**
	 * Get all Accidents
	 * @return List<Accident> accidentRepository
	 */
	//@ApiOperation(value = "Get all accidents return Accidents' list")
	@GetMapping(value="/Accidents")
	public List<Accident> accidentsList() {
		System.out.println("Accident DB All:");
		return accidentRepository.findAll();
	}
	
	/**
	 * Return an Accident by its ID
	 * @param idAcc ID of the Accident
	 * @return Accident
	 * @throws AccidentNotFoundException exception if the ID does not exist
	 */
	//@ApiOperation(value = "Get accident by its id return accident")
	@GetMapping(value="/Accidents/{id_Acc}")
	public Accident FindAccident(@PathVariable("id_Acc") int idAcc) throws AccidentNotFoundException{
		System.out.println("Accident DB get: "+idAcc);
		Accident acc = accidentRepository.findById(idAcc)
				.orElseThrow(() -> new AccidentNotFoundException("Accident num:" + idAcc + " NOT FOUND"));
		return acc;
	}
	
	/**
	 * Create an new Accident and add it in the database
	 * @param accident which all its informations
	 * @return Accident created
	 * @throws AccidentAddException exception if the ID chose already exists
	 */
	//@ApiOperation(value = "Add an accident return accident created")
	@PostMapping(value="/Accidents")
	@ResponseStatus(HttpStatus.CREATED)
	public Accident addAccident(@Valid @RequestBody Accident accident) throws AccidentAddException{
		System.out.println("Accident DB Create: \n"+accident.toString());
		/* Check if accident doesn't exist */
		Optional<Accident> opacc = accidentRepository.findById(accident.getNumAcc());
		if(opacc.isEmpty()!=true) throw new AccidentAddException("Accident numAcc: " + accident.getNumAcc() + " Already exists");
		
		/* Save new Accident */
		Accident acc = accidentRepository.save(accident);
		return acc;
	}
	 
	/**
	 * Update a Accident in the database
	 * @param accident informations to modify
	 * @param idAcc ID of Accident
	 * @return Accident updated
	 * @throws AccidentUpdateException exception if the ID chose does not exist
	 */
	//@ApiOperation(value = "Update information of an accident")
	@PutMapping(value="/Accidents/{id}")
	public Accident updateAccidentById(@Valid @RequestBody Accident accident, @PathVariable("id") int idAcc) 
		throws AccidentUpdateException{
		System.out.println("Accident DB Update: "+idAcc);
		/* Check if Accident ID exists */
		Accident acc = accidentRepository.findById(idAcc)
				.orElseThrow(() -> new AccidentUpdateException("Accident NumAcc " + idAcc + " to update NOT FOUND"));

		/* Replace Accident */
		acc = accidentRepository.save(accident);
		return acc;
	}
	
	/**
	 * Delete an Accident
	 * @param idAcc ID of accident
	 * @throws AccidentToDeleteNotFound exception if the ID chose does not exist
	 */
	//@ApiOperation(value = "Delete an accident by its id")
	@DeleteMapping(value="/Accidents/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAccident(@PathVariable("id") int idAcc) throws AccidentToDeleteNotFound{
		System.out.println("Accident DB Delete: "+idAcc);
		/* Check if Accident Id exists */
		accidentRepository.findById(idAcc)
				.orElseThrow(() -> new AccidentToDeleteNotFound("Accident numAcc: " + idAcc + "NOT FOUND"));
		accidentRepository.deleteById(idAcc);
	}
}
