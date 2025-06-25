package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	private ToDoService todoService;
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }
	
	
	@GetMapping("/todo")
		public String todo(Model model) {
		model.addAttribute("todos", todoService.getAllToDos());
		return "todoView";
		}	
}
