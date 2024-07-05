package it.lamiapizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.lamiapizzeria.model.ModelofmenuDB;
import it.lamiapizzeria.repository.MyRepository;
import jakarta.validation.Valid;

@Controller
public class MyControllerPizzeria {

	/* Per il db */
	@Autowired
	private MyRepository repository;

	@GetMapping("/index")
	public String popuateMenu(@RequestParam(name = "name", required = false) String name, Model model) {

		List<ModelofmenuDB> menu = new ArrayList<>();

		if (name == null || name.isBlank()) {
			menu = repository.findAll();
		} else {
			menu = repository.findByName(name);
		}

		model.addAttribute("pizze", menu);
		return "index";
	}

	@GetMapping("/index/{id}")
	public String paginaSingola(@PathVariable(name = "id") Integer id, Model model) {
		List<ModelofmenuDB> menu = repository.findAll();
		for (ModelofmenuDB element : menu) {
			if (element.getId() == id) {
				model.addAttribute("dettaglioPizza", element);
			}
		}

		return "dettaglioPizza";

	}
	
	

	
	@GetMapping("/index/form")
	public String create(Model model) {
	 model.addAttribute("menu", new ModelofmenuDB());

	 return "form";
	}

	
	
	@PostMapping("/index/form")
	public String FormDb(@Valid @ModelAttribute("menu") ModelofmenuDB menu,BindingResult bindingResult,
	Model model){

		if(bindingResult.hasErrors()){
			 return "/form";
			 }

			 repository.save(menu);
		return "/form";
	}
	
	
}