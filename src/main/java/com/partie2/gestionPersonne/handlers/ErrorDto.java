package com.partie2.gestionPersonne.handlers;

import java.util.ArrayList;
import java.util.List;

import com.partie2.gestionPersonne.exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto { // gestionnaire global des exceptions
	private Integer httpCode;
	private ErrorCodes code;
	private String message;
	private List<String> errors = new ArrayList<>();

}
