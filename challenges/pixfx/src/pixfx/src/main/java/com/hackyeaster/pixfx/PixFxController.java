package com.hackyeaster.pixfx;

import java.io.InputStream;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PixFxController {

	private static final String ERROR = "error";
	private static final String CODE = "code";
	private static final String PICTURE = "picture";
	private static final String IMAGE = "image";
	private static final String EFFECT = "effect";
	private static final String SECRET_KEY = "yodeldihodel536475827365";

	Logger log = LoggerFactory.getLogger(PixFxController.class);

	private List<String> images = new LinkedList<>();
	private List<Integer> effects = new LinkedList<>();

	public PixFxController() {
		images.add("thecat");
		images.add("chaining");
		images.add("flipper");
		images.add("pony");
		images.add("wiserabbit");
		effects.add(1);
		effects.add(2);
		effects.add(3);
		effects.add(4);
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/code")
	public String code(@NotEmpty @Size(min = 3, max = 8) @RequestParam String image,
			@NotEmpty @Min(1) @Max(3) @RequestParam Integer effect, Model model) {
		if (!images.contains(image)) {
			if ("egg".equals(image)) {
				return error(model, "Not allowed to use that image.");
			} else {
				return error(model, "Unknown image.");
			}
		} else if (!effects.contains(effect)) {
			return error(model, "Unknown effect.");
		}
		String json = String.format("{\"image\": \"%s\", \"effect\": %s}", image, effect);
		String code;
		try {
			code = CryptoHelper.bytesToHex(CryptoHelper.encrypt(json, SECRET_KEY));
		} catch (Exception e) {
			return error(model, "Unknown Error.");
		}
		model.addAttribute(CODE, code);
		return CODE;
	}

	@GetMapping("/picture")
	public String picture(Model model, @Size(min = 96, max = 96) @RequestParam String code) {
		String json;
		try {
			json = CryptoHelper.decrypt(CryptoHelper.hexToBytes(code), SECRET_KEY);
		} catch (Exception e) {
			return error(model, "Decryption Error.");
		}
		String image = null;
		Integer effect = 0;
		String picture = null;
		try {
			JsonNode rootNode = new ObjectMapper().readTree(json);
			Iterator<String> it = rootNode.fieldNames();
			String key = null;
			while (it.hasNext()) {
				key = it.next();
				if (IMAGE.equals(key)) {
					image = rootNode.get(key).textValue();
				} else if (EFFECT.equals(key)) {
					effect = rootNode.get(key).intValue();
				} else {
					return error(model, "Unknown field '" + key + "'");
				}
			}
		} catch (Exception e) {
			return error(model, "Parser Error.");
		}

		if ((images.contains(image) || "egg".equals(image)) && effects.contains(effect)) {
			try {
				String fileName = String.format("jpgrenderimg/%s_%s.jpg", image, effect);
				InputStream is;
				is = new ClassPathResource(fileName).getInputStream();
				byte[] bytes = IOUtils.toByteArray(is);
				picture = "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
			} catch (Exception e) {
				return error(model, "Error processing image " + image);
			}
		} else {
			return error(model, "Error processing image " + image);
		}
		model.addAttribute(PICTURE, picture);
		return PICTURE;
	}

	private String error(Model model, String msg) {
		model.addAttribute(ERROR, msg);
		return ERROR;
	}

}