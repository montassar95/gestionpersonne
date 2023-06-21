package com.partie2.gestionPersonne.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partie2.gestionPersonne.dto.PersonneDto;
import com.partie2.gestionPersonne.exception.EntityNotFoundException;
import com.partie2.gestionPersonne.exception.ErrorCodes;
import com.partie2.gestionPersonne.exception.InvalidEntityException;
import com.partie2.gestionPersonne.model.Personne;
import com.partie2.gestionPersonne.repository.PersonneRepository;
import com.partie2.gestionPersonne.services.PersonneService;
import com.partie2.gestionPersonne.validator.PersonneValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonneServiceImpl implements PersonneService {

	private PersonneRepository personneRepository;

	@Autowired
	public PersonneServiceImpl(PersonneRepository personneRepository) {

		this.personneRepository = personneRepository;
	}

	@Override
	public PersonneDto save(PersonneDto personneDto) {

		List<String> errors = PersonneValidator.validate(personneDto);
		if (!errors.isEmpty()) {
			log.error("Person is not valid {}", personneDto);
			throw new InvalidEntityException("Person is not valid", ErrorCodes.Personne_Not_Valid, errors);
		}

		return PersonneDto.fromEntity(personneRepository.save(PersonneDto.toEntity(personneDto)));
	}

	@Override
	public PersonneDto findById(Long id) {
		if (id == null) {
			log.error("Client id is null");
			return null;
		}

		Optional<Personne> personne = personneRepository.findById(id);
		if (personne.isPresent()) {
			PersonneDto personneDto = PersonneDto.fromEntity(personne.get());
			return personneDto;
		} else {
			throw new EntityNotFoundException("Aucun client avec l'ID " + id, ErrorCodes.Personne_Not_Found);
		}

	}

	@Override
	public List<PersonneDto> findAll() {

		return personneRepository.findAllByOrderByNomPrenomAsc().stream().map(PersonneDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("Person id is null");
			return;
		}

		personneRepository.deleteById(id);

	}
}
