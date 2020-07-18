package edu.vinaenter.cland.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.cland.models.Categories;

@Repository
public class CategoryDAO extends AbstractDAO{

	private static final String FIND_ALL ="SELECT cid,cname FROM categories ORDER BY cid DESC";
	private static final String ADD_ITEM ="INSERT INTO categories(cname) values(?)";
	private static final String FIND_BY_NAME ="SELECT * FROM categories WHERE cname = ?";
	private static final String FIND_BY_ID = "SELECT * FROM categories WHERE cid = ?";
	private static final String EDIT ="UPDATE categories SET cname = ? WHERE cid = ?";
	private static final String DEL = "DELETE FROM categories WHERE cid=?";
			
	public List<Categories> findAll(){
		return getJdbcTemplate().query(FIND_ALL,new BeanPropertyRowMapper<>(Categories.class));
	}
	
	public int addItem(Categories cat) {
		return getJdbcTemplate().update(ADD_ITEM, new Object[] {cat.getCname()});
	}
	public List<Categories> checkExist(String cname) {
		return getJdbcTemplate().query(FIND_BY_NAME, new BeanPropertyRowMapper<>(Categories.class), new Object[] {cname});
	}
	public Categories getById(int cid) {
		return getJdbcTemplate().queryForObject(FIND_BY_ID, new BeanPropertyRowMapper<>(Categories.class),new Object[] {cid});
	}
	public int editItem(Categories categories) {
		return getJdbcTemplate().update(EDIT,new Object[] {categories.getCname(),categories.getCid()});
	}
	public int delItem(int cid) {
		return getJdbcTemplate().update(DEL, new Object[] {cid});
	}
	
}
