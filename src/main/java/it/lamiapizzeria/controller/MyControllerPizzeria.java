package it.lamiapizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.lamiapizzeria.model.ModelofmenuDB;
import it.lamiapizzeria.repository.MyRepository;


@Controller
public class MyControllerPizzeria {	
	
	/*Per il db*/
	@Autowired
	private MyRepository repository;
	
	@GetMapping("/")
	public String popuateMenu(Model model) {
		
		
		List<ModelofmenuDB> menu = repository.findAll();
		model.addAttribute("pizze", menu);
		System.out.println("lepizzeso");
		for(ModelofmenuDB m : menu) {
			System.out.println(m.getDescrizione());
		}
		return "index";
	}

}
