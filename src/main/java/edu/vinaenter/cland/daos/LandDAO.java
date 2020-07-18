package edu.vinaenter.cland.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.cland.dtos.LandDTO;
import edu.vinaenter.cland.models.Land;

@Repository
public class LandDAO extends AbstractDAO {

	private static final String FIND_ALL = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY l.lid DESC";
	private static final String FIND_ALL_NEW = "SELECT lid, lname FROM lands ORDER BY date_create DESC";
	private static final String TOTAL_ROW = "SELECT COUNT(*) AS totalRow FROM lands"; 
	private static final String DEL_SQl = "DELETE FROM lands WHERE lid = ?";
	private static final String FIND_ONE = "SELECT lid, lname, description, address, "
			+ "date_create AS dateCreate, picture, "
			+ "count_views AS countViews, area, cid "
			+ "FROM land WHERE lid = ?";
	
	public List<Land> fillAll() {
		return getJdbcTemplate().query(FIND_ALL,new BeanPropertyRowMapper<>(Land.class));
	}		
	
	public List<Land> fillAllNew() {
		return getJdbcTemplate().query(FIND_ALL_NEW,new BeanPropertyRowMapper<>(Land.class));
	}	
	
	public List<Land> findCatHot() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int totalRow() {
		return getJdbcTemplate().queryForObject(TOTAL_ROW, Integer.class);
	}
	
	public int del(int landId) {
		return getJdbcTemplate().update(DEL_SQl, new Object[] {landId});
	}
	
	public LandDTO findOne(int landId) {
		return getJdbcTemplate().queryForObject(FIND_ONE, 
				new Object[] {landId}, 
				new BeanPropertyRowMapper<>(LandDTO.class));
	}

}
