package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView";
    }

    @PostMapping("/form")
    public String checkForm(
            @Validated @ModelAttribute("contactForm") ContactForm contactForm,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/form";
        }

        redirectAttributes.addFlashAttribute("contactForm", contactForm);
        return "redirect:/confirm";
    }

    @GetMapping("/confirm")
    public String showConfirm(@ModelAttribute("contactForm") ContactForm contactForm) {
        return "confirmView";
    }
}
