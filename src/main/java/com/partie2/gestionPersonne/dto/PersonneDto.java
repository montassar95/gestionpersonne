package com.partie2.gestionPersonne.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import com.partie2.gestionPersonne.model.Personne;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonneDto {

	private Long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int age;

	public static PersonneDto fromEntity(Personne personne) {
		if (personne == null) {
			// to do throw an exception
			return null;
		}

		LocalDate dateNaissance = convertToLocalDate(personne.getDateNaissance());
		int age = calculateAge(dateNaissance);

		return PersonneDto.builder().id(personne.getId()).nom(personne.getNom()).prenom(personne.getPrenom())
				.dateNaissance(personne.getDateNaissance()).age(age).build();
	}

	public static Personne toEntity(PersonneDto personneDto) {
		if (personneDto == null) {
			// to do throw an exception
			return null;
		}

		return Personne.builder().id(personneDto.getId()).nom(personneDto.getNom()).prenom(personneDto.getPrenom())
				.dateNaissance(personneDto.getDateNaissance()).build();
	}

	private static LocalDate convertToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private static int calculateAge(LocalDate dateNaissance) {
		LocalDate maintenant = LocalDate.now();
		Period difference = Period.between(dateNaissance, maintenant);
		return difference.getYears();
	}
}
