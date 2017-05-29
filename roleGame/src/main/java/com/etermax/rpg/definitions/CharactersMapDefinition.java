package com.etermax.rpg.definitions;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="characters")
@XmlAccessorType(XmlAccessType.FIELD)
public class CharactersMapDefinition {

	@XmlElement(name = "character")
	private List<CharacterMapDefinition> characters = null;

	public List<CharacterMapDefinition> getCharacters() {
		return characters;
	}

	public void setCharacters(List<CharacterMapDefinition> characters) {
		this.characters = characters;
	}
	
}
