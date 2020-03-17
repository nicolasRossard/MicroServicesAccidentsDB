package com.insa.datasProcessingService.entities;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 * CLASS
 * Not USED
 * Shoulb be used to create manually graphs
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultsResponse<T> {
	private String title;
	private String titleAxisX;
	private String titleAxisY;
	private Map<Object,Object> valueXY;
	

}
