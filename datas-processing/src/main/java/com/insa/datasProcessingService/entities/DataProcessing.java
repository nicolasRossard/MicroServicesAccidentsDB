package com.insa.datasProcessingService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * Class DataProcessing
 * Contains all requests asked by the customer
 * @author Nicolas
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataProcessing {
	//int yearBeg;
	//int yearEnd;
	/* Boolean Number of vehicules */
	private String isVehNumber;
	
	/* Boolean Number of accidents */
	private String isAccNumber;
	
	/* Boolean Number of victims */
	private String isVictNumber;
	
	/* Graph of Number of vehicules */
	private final String GraphVehNumber = "/nbVeh";
	
	/* Graph of Number of accidents */
	private final String GraphAccNumber = "/nbAcc";
	
	/* Graph of Number of victims */
	private final String GraphVictNumber = "/nbVict";
}
