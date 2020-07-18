package edu.vinaenter.cland.services;

import java.util.List;

import edu.vinaenter.cland.models.Categories;

public interface CategoryService  {
	List<Categories> findAll();

	int AddItem(Categories cat);

	List<Categories> checkExist(String cname);

	Categories findById(int cid);

	int editItem(Categories cat);

	int delItem(int cid);
}
