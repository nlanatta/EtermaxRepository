package com.etermax.rpg.factory;

import org.springframework.stereotype.Component;

import com.etermax.rpg.definitions.CharactersDefinition;
import com.etermax.rpg.model.Character;
import com.etermax.rpg.utils.IdGenerator;

@Component
public class CharacterFactory {
	
	private CharactersDefinition charactersDefinition;

	public void setCharactersDefinition(CharactersDefinition charactersDefinition) {
		this.charactersDefinition = charactersDefinition;
		this.charactersDefinition.initMapCharacters();
	}
	
	public Character getCharacterById(String id)
	{
		Character character = new Character(charactersDefinition.getCharacterMap().get(id));
		character.setId(IdGenerator.random());
		return character ;
	}
}
