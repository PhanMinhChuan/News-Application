package edu.vinaenter.cland.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.cland.daos.CategoryDAO;
import edu.vinaenter.cland.daos.LandDAO;
import edu.vinaenter.cland.dtos.LandDTO;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.LandService;

@Service
public class LandServiceImpl implements LandService {

	@Autowired
	private LandDAO landDAO;
	
	@Override
	public List<Land> findAll() {
		return landDAO.fillAll();
	}

	@Override
	public int totalRow() {
		return landDAO.totalRow();
	}

	@Override
	public int del(int landId) {
		return landDAO.del(landId);
	}

	@Override
	public LandDTO findOne(int landId) {
		// TODO Auto-generated method stub
		return landDAO.findOne(landId);
	}

	@Override
	public List<Land> findAllNew() {
		// TODO Auto-generated method stub
		return landDAO.fillAllNew();
	}

	@Override
	public List<Land> findCatHot() {
		// TODO Auto-generated method stub
		return landDAO.findCatHot();
	}

}
