package com.insa.victimService.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.insa.victimService.dao.VictimRepository;
import com.insa.victimService.entities.Victim;
import com.insa.victimService.web.exceptions.VictimAddException;
import com.insa.victimService.web.exceptions.VictimNotFoundException;
import com.insa.victimService.web.exceptions.VictimToDeleteNotFound;
import com.insa.victimService.web.exceptions.VictimUpdateException;


/**
 * Controller which communicates with Victims DB
 * INFORMATION
 * JPARepository is created. It's possible to use JPAPreository and all functions which are
 * already implemented by using url: LocalHost...../victims (victims without CAPS)
 * this controller is made manually to use what we saw in class
 * @author Nicolas
 *
 */

//@RefreshScope
/* localhost:8084/actuator/..... */
@RestController
public class VictimController {
	@Autowired
	private VictimRepository victimRepository;
	
	/**
	 * Get all victims
	 * @return List<Victim> victimRepository
	 */
	//@ApiOperation(value = "Get all Victims return Victims' list")
	@GetMapping(value="/Victims")
	public List<Victim> victimsList() {
		System.out.println("Victim DB All:");
		return victimRepository.findAll();
	}
	
	/**
	 * Return an Victim by its ID
	 * @param idVict ID of Victim
	 * @return Victim
	 * @throws VictimNotFoundException exception if the ID does not exist
	 */
	//@ApiOperation(value = "Find victim by its ID")
		@GetMapping(value="/Victims/{id_vict}")
		public Victim FindVictim(@PathVariable("id_vict") int idVict) throws VictimNotFoundException{
			System.out.println("Victim DB get: "+idVict);
			Victim vict = victimRepository.findById(idVict)
					.orElseThrow(() -> new VictimNotFoundException("Victim num:" + idVict + " NOT FOUND"));
			return vict;
		}
		
	/**
	 * Create an new Victim and add it in the database
	 * @param victim which all its informations
	 * @return Victim created
	 * @throws VictimAddException exception if the ID chose already exists
	 */
		//@ApiOperation(value = "Add an victim return victim created")
		@PostMapping(value="/Victims")
		@ResponseStatus(HttpStatus.CREATED)
		public Victim addVictim(@Valid @RequestBody Victim victim) throws VictimAddException{
			System.out.println("Victim DB Create: \n"+victim.toString());
			/* Check if Victim doesn't exist */
			Optional<Victim> opacc = victimRepository.findById(victim.getNumVict());
			if(opacc.isEmpty()!=true) throw new VictimAddException("Victim num: " + victim.getNumVict()+ " Already exists");
			
			/* Save new Victim */
			Victim vict = victimRepository.save(victim);
			return vict;
		}
		
		/**
		 * Update a Victim in the database
		 * @param victim informations to modify
		 * @param idVict ID of the victim
		 * @return Victim updated
		 * @throws VictimUpdateException exception if the ID chose does not exist
		 */
		//@ApiOperation(value = "Update information of a victim")
		@PutMapping(value="/Victims/{id}")
		public Victim updateVictimById(@Valid @RequestBody Victim victim, @PathVariable("id") int idVict) 
			throws VictimUpdateException{
			System.out.println("Victim DB Update: "+idVict);
			/* Check if Victim ID exists */
			Victim vict = victimRepository.findById(idVict)
					.orElseThrow(() -> new VictimUpdateException("Victim num " + idVict + " to update NOT FOUND"));

			/* Replace Victim */
			vict = victimRepository.save(victim);
			return vict;
		}
		/**
		 * Delete a Victim
		 * @param idVict ID of the victim
		 * @throws VictimToDeleteNotFound exception if the ID chose does not exist
		 */
		//@ApiOperation(value = "Delete a victim by its id")
		@DeleteMapping(value="/Victims/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteVictim(@PathVariable("id") int idVict) throws VictimToDeleteNotFound{
			System.out.println("Victim DB Delete: "+idVict);
			/* Check if Victim Id exists */
			victimRepository.findById(idVict)
					.orElseThrow(() -> new VictimToDeleteNotFound("Victim num " + idVict + " NOT FOUND"));
			victimRepository.deleteById(idVict);
		}
}
