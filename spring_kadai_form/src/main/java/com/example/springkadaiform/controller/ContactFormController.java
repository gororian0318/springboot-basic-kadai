package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	
	
	@GetMapping("/form")
	public String showForm (ContactForm contactForm) {
		return "contactFormView";
	
	}
	
	@PostMapping("/form")
	public String checkForm (
		@Validated ContactForm contactForm, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "contactFormView";
		}
		
		return "confirmView";
	
	}

}
