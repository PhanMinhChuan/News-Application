package edu.vinaenter.cland.controllers.clands;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cland")
public class ClandContactClandController {

	@GetMapping("contact")
	public String contact() {
		return "cland.contact";
	}
}
