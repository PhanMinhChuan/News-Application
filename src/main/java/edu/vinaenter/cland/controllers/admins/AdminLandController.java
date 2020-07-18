package edu.vinaenter.cland.controllers.admins;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.cland.constants.GlobalsConstant;
import edu.vinaenter.cland.dtos.LandDTO;
import edu.vinaenter.cland.models.Land;
import edu.vinaenter.cland.services.LandService;
import edu.vinaenter.cland.utils.FileUtil;
import edu.vinaenter.cland.utils.PaginationUtil;

@Controller
@RequestMapping("admin/land")
public class AdminLandController {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private LandService landService;
	
	@RequestMapping(value = {"index", "index/{page}"}, method = RequestMethod.GET)
	public String news(Model model, @PathVariable(required= false, name ="page") Integer page) {
		if (page == null) {
			page = 1;
		}
		// offset = (currentPage - 1) * row_count
		int offset = PaginationUtil.getOffSet(page);
		
		List<Land> landList = landService.findAll();
		model.addAttribute("landList", landList);
		int totalRow = landService.totalRow();
		int totalPage = (int) Math.ceil( (float) totalRow / GlobalsConstant.LIMIT_Page);
		model.addAttribute("totalPage", totalPage);
		
		System.out.println(messageSource.getMessage("success", null, Locale.getDefault()));
		return "admin.land.index";
	}
	
	@RequestMapping(value ="/del/{landId}", method = RequestMethod.GET)
	public String del(@PathVariable Integer landId, HttpServletRequest request, RedirectAttributes rd)
	{
		//check picture null?
		LandDTO landDTO = landService.findOne(landId);
		String oldPic = landDTO.getPicture();
		FileUtil.delPic(oldPic, request);
		if(landService.del(landId) > 0) {
			rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("success", null, Locale.getDefault()));
		}
		rd.addFlashAttribute(GlobalsConstant.MSG, messageSource.getMessage("error", null, Locale.getDefault()));
		return "redirect:/admin/land/index";
	}
	
	
	
	/*
	 * @GetMapping("news") public String news() { return "admin.news"; }
	 */
}
