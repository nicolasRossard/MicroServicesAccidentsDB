package com.insa.victimService.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Class Victim
 * This class is simplified. It does not contain all variables of the CSV document
 * The entity Victim corresponds to the csv users.csv
 * https://www.kaggle.com/ahmedlahlou/accidents-in-france-from-2005-to-2016#users.csv
 * @author Nicolas
 */
@Entity
@Data
@NoArgsConstructor
@ToString
public class Victim {
	@Id
	private int numVict;
	
	/* Id Accident */
	private int numAcc;
	
	/* Id of vehicule */
	private String numVeh;
	
	@Range(min=1,max=4,message = "catu of victims [1-4]")
	private int catu;
	
	@Range(min=1,max=4,message = "gravity of victims [1-4]")
	private int grav;
	
	@Range(min=1,max=2,message = "sex of victims [1-2]")
	private int sex;
	
	private int birthDate;
	public Victim(int numVict, int numAcc, String numVeh,
			@Range(min = 1, max = 4, message = "catu of victims [1-4]") int catu,
			@Range(min = 1, max = 4, message = "gravity of victims [1-4]") int grav,
			@Range(min = 1, max = 2, message = "sex of victims [1-2]") int sex, int birthDate) {
		super();
		this.numVict = numVict;
		this.numAcc = numAcc;
		/* Check if Victim is pedestrian */
		if (catu>=3) {
			this.numVeh = "NULL"; /* not in vehicule */
		}else {
			this.numVeh = numVeh; /* in vehicule */
		}
		
		/* Check if numVeh is null */
		if(numVeh==null) {
			this.numVeh ="NULL";
		}
		this.catu = catu;
		this.grav = grav;
		this.sex = sex;
		this.birthDate = birthDate;
	}
}
