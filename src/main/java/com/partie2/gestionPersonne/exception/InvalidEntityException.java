package com.partie2.gestionPersonne.exception;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException {

	@Getter
	private ErrorCodes errorCode;

	@Getter
	List<String> errors;

	public InvalidEntityException(String message) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause) {
		super(message);
	}

	public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public InvalidEntityException(String message, ErrorCodes errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public InvalidEntityException(String message, ErrorCodes errorCode, List<String> errors) {
		super(message);
		this.errorCode = errorCode;
		this.errors = errors;
	}

}
