package com.etermax.rpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Character does not exist.")
public class CharacterNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String characterId;

	public CharacterNotFoundException(String characterId) {
		this.characterId = characterId;
	}

	public String getCharacterId() {
		return characterId;
	}
}