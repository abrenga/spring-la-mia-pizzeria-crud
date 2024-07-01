package it.lamiapizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.lamiapizzeria.model.ModelofmenuDB;
import it.lamiapizzeria.repository.MyRepository;


@Controller
public class MyControllerPizzeria {	
	
	/*Per il db*/
	@Autowired
	private MyRepository repository;
	
	@GetMapping("/")
	public String popuateMenu(@RequestParam(name="name", required = false)String name,Model model) {	
		
		
		List<ModelofmenuDB> menu = new ArrayList<>();
		
			if(name == null|| name.isBlank()) {
				menu= repository.findAll();
			}else{
				menu = repository.findByName(name);
			}
				
		model.addAttribute("pizze", menu);
		return "index";
	}
	
	
	@GetMapping("/index/{id}")
	public String paginaSingola(@PathVariable(name="id") Integer id, Model model) {
		List<ModelofmenuDB> menu = repository.findAll();
		for(int i =0; i<menu.size(); i++) {
			if(menu.get(i).getId() == id){
				model.addAttribute("dettaglioPizza", menu.get(i));
			}
		}
		
		
		return "dettaglioPizza";
		
	}
	
	
	

}
