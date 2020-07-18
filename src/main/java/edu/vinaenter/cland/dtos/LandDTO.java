package edu.vinaenter.cland.dtos;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LandDTO {
	
	private int lid;
	
	private String lname;
	
	private String description;
	
	private Timestamp dateCreate;
	
	private int cid;
	
	private String picture;
	
	private int area;
	
	private String address;
	
	private int countViews;
	
}
