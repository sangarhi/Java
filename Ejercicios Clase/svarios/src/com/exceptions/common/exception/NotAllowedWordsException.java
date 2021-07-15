package com.exceptions.common.exception;

import com.exceptions.common.NotAllowedWord;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class NotAllowedWordsException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo NotAllowedWord llamado "word"
	//private final NotAllowedWord word;
	private  NotAllowedWord word;	

	
	public NotAllowedWordsException(String code,NotAllowedWord word,String message) {
		super(code,message);
		this.word = word;
	}

	public NotAllowedWord getWord() {
		return word;
	}
	
	
	
}
