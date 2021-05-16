package com.hackyeaster.cafeshop;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.hash.Hashing;

@Controller
public class CafeController {

	private static final String PATTERN = "[0-9]{8} [a-zA-Z ]{3,30}";
    
	@PostMapping("/order")
	public String order(@RequestParam(name = "id", required = true) String id, Model model, HttpServletResponse resp) {
		if (Pattern.matches(PATTERN, id)) {
			String hash = Hashing.sha256().hashString(id, StandardCharsets.UTF_8).toString();
			String item = null;
			if (hash.contains("decaf") && hash.contains("c01a")) {
				item = "7ef384aa6ec128ef.png";
			} else if (hash.contains("beef")) {
				item = "beef.png";
			} else if (hash.contains("cafe")) {
				item = "cafe.png";
			} else if (hash.contains("c01a")) {
				item = "cola.png";
			} 
			if (item!=null) {
				model.addAttribute("item", item);
				return "delivery";
			}
			else {
				return "unknown";
			}
		}
		resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "400";
	}

}