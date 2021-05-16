package com.hackyeaster.seasons;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FourSeasonsController {

	Logger log = LoggerFactory.getLogger(FourSeasonsController.class);

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/season")
	public String path(@RequestParam String season) {
		return "page-" + season;
	}

	@GetMapping("/comment")
	public String comment(Model model) {
		return "comment";
	}

	@PostMapping("/comment")
	public String addComment(@RequestParam(required = false) String bunny, Model model, HttpServletResponse resp) {
		if ("yes".equals(bunny)) {
			resp.setHeader("Location", "/images/rickroll.jpg");
			resp.setStatus(302);
		}
		return "thanks";
	}

}