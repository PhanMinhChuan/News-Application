package edu.vinaenter.cland.controllers.clands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.cland.models.Categories;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.CategoryService;
import edu.vinaenter.cland.services.LandService;


@Controller
@RequestMapping("cland")
public class ClandClandController {
	
	@Autowired
	CategoryService categoryService; 
	
	@Autowired
	LandService landService; 
	
	@ModelAttribute
	public void addCommonObject(Model model) {
		List<Categories> findAll = categoryService.findAll();
		model.addAttribute("catList", findAll);
	}
	
	@ModelAttribute
	public void listLandNew(Model model) {
		List<Land> findAllNew = landService.findAllNew();
		model.addAttribute("newLandList", findAllNew);
	}
	
	@ModelAttribute
	public void listCatHot(Model model) {
		List<Land> findAllNew = landService.findCatHot();
		model.addAttribute("newLandList", findAllNew);
	}

	@GetMapping("index")
	public String index() {
		
		return "cland.index";
	}
	@GetMapping("cat")
	public String cat() {
		return "cland.cat";
	}
	@GetMapping("detail")
	public String detail() {
		return "cland.detail";
	}
	
}
