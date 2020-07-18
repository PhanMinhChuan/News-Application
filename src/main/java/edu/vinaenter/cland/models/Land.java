package edu.vinaenter.cland.models;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Land {
	private int lid;
	
	private String lname;
	
	private String description;
	
	private Timestamp dateCreate;
	
	private Categories category;
	
	private String picture;
	
	private int area;
	
	private String address;
	
	private int countViews;
	
}
