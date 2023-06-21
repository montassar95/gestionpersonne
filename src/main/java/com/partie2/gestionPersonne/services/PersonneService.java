package com.partie2.gestionPersonne.services;

import java.util.List;
 
import com.partie2.gestionPersonne.dto.PersonneDto;

public interface PersonneService {
	
	PersonneDto save(PersonneDto personnetDto);
	
	PersonneDto findById(Long id);
	
	List<PersonneDto> findAll();
	
	void delete(Long id);
	
	

}
