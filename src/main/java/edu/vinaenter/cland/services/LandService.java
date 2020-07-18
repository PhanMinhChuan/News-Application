package edu.vinaenter.cland.services;

import java.util.List;

import edu.vinaenter.cland.dtos.LandDTO;
import edu.vinaenter.cland.models.Land;

public interface LandService {
	List<Land> findAll();
	
	List<Land> findAllNew();

	int totalRow();
	
	int del(int landId);
	
	LandDTO findOne(int landId);

	List<Land> findCatHot();
	
}
