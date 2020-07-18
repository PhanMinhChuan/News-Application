package edu.vinaenter.cland.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminIndexController {
	
	@GetMapping("index")
	public String land() {
		return "admin.index";
	}
	
}
