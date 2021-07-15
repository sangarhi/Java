package com.proyecto.common.exception;

import com.proyecto.common.NotAllowedWord;

//Paso 1. Identificar esta clase commo hija de StringNotValidException
public class NotAllowedWordsException extends StringNotValidException {

	// Paso 2. Indicar un atributo inmutable tipo NotValidWord llamado "word"
	private NotAllowedWord word;

	public NotAllowedWordsException( String code, String msg, NotAllowedWord word) {
		super(code, msg);
		this.word = word;
	}

	/**
	 * @return the word
	 */
	public NotAllowedWord getWord() {
		return word;
	}

	
	
	
	
	
}
