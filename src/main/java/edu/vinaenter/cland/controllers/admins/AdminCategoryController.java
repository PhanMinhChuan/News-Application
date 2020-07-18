package edu.vinaenter.cland.controllers.admins;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.models.Categories;
import edu.vinaenter.cland.services.CategoryService;

@Controller
@RequestMapping("admin/cat")
public class AdminCategoryController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private CategoryService catService;
	
	@GetMapping("index")
	public String cat(Model model) {
		List<Categories> catList = catService.findAll();
		model.addAttribute("catList", catList);
		System.out.println(messageSource.getMessage("success",null,Locale.getDefault()));;
		return "admin.cat.index";
	}
	
	@GetMapping("add")
	public String add() {
		return "admin.cat.add";
	}
	
	//Hứng valid ngay sau categori 
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("cat") Categories cat, BindingResult rs, RedirectAttributes rd) {
		if(rs.hasErrors()) {
			return "admin.cat.add";
		}
		System.out.println(cat);
		List<Categories> checkExist = catService.checkExist(cat.getCname());
		
		if(checkExist.size()==0) {
			int addItem = catService.AddItem(cat);
			if(addItem>0) {
				rd.addFlashAttribute( GlobalsConstant.MSG,messageSource.getMessage("success",null,Locale.getDefault()));
				return "redirect:/admin/cat/index";
			} else {
				rd.addFlashAttribute( GlobalsConstant.MSG,messageSource.getMessage("error",null,Locale.getDefault()));
				return "admin.cat.add";
			}
		} else {
			rd.addFlashAttribute( GlobalsConstant.MSG,messageSource.getMessage("doublecat",null,Locale.getDefault()));
			return "redirect:/admin/cat/add";
		}
	}
	
	@GetMapping("edit/{cid}")
	public String edit(@PathVariable int cid,Model model) {
		System.out.println(cid);
		Categories findById = catService.findById(cid);
		model.addAttribute("catById", findById);
		return "admin.cat.edit";
	}
	
	@PostMapping("edit/{cid}")
	public String edit(@PathVariable int cid,@Valid @ModelAttribute("cat") Categories cat, 
			BindingResult rs, RedirectAttributes rd,Model model) {
		if(rs.hasErrors()) {
			return "admin.cat.edit";
		}
		cat.setCid(cid);
		List<Categories> checkExist=catService.checkExist(cat.getCname());
		if(checkExist.size()==0) {
			int editItem = catService.editItem(cat);
			if(editItem > 0) {
				rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success",null, Locale.getDefault()));
				return "redirect:/admin/cat/index";
			} else {
				Categories findById = catService.findById(cat.getCid());
				model.addAttribute("catById", findById);
				rd.addFlashAttribute( GlobalsConstant.MSG,messageSource.getMessage("error",null,Locale.getDefault()));
				return "redirect:/admin/cat/edit";
			}
		} else {
			model.addAttribute("cname", cat.getCname());
			rd.addFlashAttribute( GlobalsConstant.MSG,messageSource.getMessage("error",null,Locale.getDefault()));
			return "redirect:/admin/cat/edit/"+cid;
		}
	}
	
	@GetMapping("del/{cid}")
	public String del(@PathVariable int cid,RedirectAttributes rd) {
		int delItem = catService.delItem(cid);
		if(delItem > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success",null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		} else {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error",null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
	}
}
