package com.insa.accidentService.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Class Accident
 * This class is simplified. It does not contain all variables of the CSV document
 * @author Nicolas
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Accident {
	/* ID of the accident */
	@Id 
	private int numAcc;
	
	/* Year of the accident */
	/* WARNING in DB 05 <= year <= 16 it must add 2000 */
	@Range(min=2005,max=2016,message = "Accident between 2005 and 2016")
	private int year;
	
	/* 2=accident in agglomeration 1=outside */
	@Range(min=1,max=2,message = "agg = 2 for accident in agglomeration and 1 outside agglomeration")
	private int agg;
	
	/* Weather
	 * 1 – Normale
	 * 2 – Light rain
	 * 3 – Heavy rain
	 * 4 – Snow -hail
	 * 5 – Fog - smoe
	 * 6 – Strong wind - storm
	 * 7 – Dazzling weather
	 * 8 – Cloudy weather
	 * 9 – Autre
	 */
	@Range(min=1,max=9,message = "Atm value NOT RESPECTED")
	private int atm;
	
	/*
	 * public Accident(Long id, int i, int j, int k) { this.numAcc=id; this.year =
	 * i; this.agg = j; this.atm = k; }
	 */
}
