package com.partie2.gestionPersonne.exception;

 
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor 
public enum ErrorCodes {
    Personne_Not_Found(1000),
	Personne_Not_Valid(1001),
	Personne_Not_Valid_DateNaissance(1002);
     
    private final Integer code;
}
