package it.lamiapizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.lamiapizzeria.model.ModelofmenuDB;





public interface MyRepository extends JpaRepository<ModelofmenuDB, Integer>{
	
	
	
}