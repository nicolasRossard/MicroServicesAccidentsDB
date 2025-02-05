package com.insa.datasProcessingService.web.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * DP Controller class
 * which permits to answer to requests of client
 * @author Nicolas
 *
 */
@Controller
public class DPController {
	private String url = "http://localhost:8082/images/" ;
	/* Get all datas from Accidents DB, Vehicule DB and Victims DB */
	
	
	/**
	 * Answer to the request:
	 * number of accident between 2005-2016
	 * TODO for now return only a graph pre-recorded
	 * @return Response which contains the url of the graph nb_acc.jpg
	 */
	@GetMapping("/nbAcc")
	public ResponseEntity<String> getNbAcc() {
		System.out.println("/nbAcc");
		
		/* TO DO DataProcessing for number of Number of Accidents 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		String resultGraph = "nb_acc.jpg";
		ResponseEntity<String> response = new ResponseEntity<>(this.url + resultGraph,HttpStatus.OK);
		System.out.println(response.toString());
		return response;
	}
	
	/**
	 * Answer to the request:
	 * number of victims between 2005-2016
	 * TODO for now return only a graph pre-recorded
	 * @return Response which contains the url of the graph nb_vict.jpg
	 */
	@GetMapping("/nbVict")
	public ResponseEntity<String> getNbVict() {
		System.out.println("/nbVict");
		
		/* TODO DataProcessing for number of Number of Victims 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		String resultGraph = "nb_vict.jpg";
		ResponseEntity<String> response = new ResponseEntity<>(this.url + resultGraph,HttpStatus.OK);
		System.out.println(response.toString());
		return response;
	}
	
	/**
	 * Answer to the request:
	 * number of vehicules crashed between 2005-2016
	 * TODO for now return only a graph pre-recorded
	 * @return Response which contains the url of the graph nb_veh.jpg
	 */
	@GetMapping("/nbVeh")
	public ResponseEntity<String> getNbVeh() {
		
		System.out.println("/nbVeh");
		
		/* TODO DataProcessing for number of Number of Victims 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		String resultGraph = "nb_veh.jpg";
		ResponseEntity<String> response = new ResponseEntity<>(this.url + resultGraph,HttpStatus.OK);
		System.out.println(response.toString());
		System.out.println(response.getBody());
		return response;
		
	}
}
