package com.partie2.gestionPersonne.validator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.partie2.gestionPersonne.dto.PersonneDto;

public class PersonneValidator {

    public static List<String> validate(PersonneDto clientDto) {

        List<String> errors = new ArrayList<>();

        if (clientDto == null) {
            errors.add("Veuillez renseigner le nom");
            errors.add("Veuillez renseigner le prénom");
            errors.add("Veuillez renseigner la date de naissance");

            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("Veuillez renseigner le nom");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("Veuillez renseigner le prénom");
        }
        if (clientDto.getDateNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance");
        } else {
            Date dateNaissance = clientDto.getDateNaissance();

            Calendar calendarNaissance = Calendar.getInstance();
            calendarNaissance.setTime(dateNaissance);

            Calendar calendarLimite = Calendar.getInstance();
            calendarLimite.add(Calendar.YEAR, -150); // Limite d'âge de 150 ans

            Calendar maintenant = Calendar.getInstance();

            if (calendarNaissance.after(maintenant)) {
                errors.add("La date de naissance est postérieure à la date actuelle");
            } else if (calendarNaissance.before(calendarLimite)) {
                errors.add("L'âge est supérieur à 150 ans");
            }
        }

        return errors;
    }
}
