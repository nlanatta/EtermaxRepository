package com.etermax.rpg.definitions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="game")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameDefinition {
	
	@XmlAttribute
	private String name;
	
	@XmlElement(name = "characters")
	private CharactersMapDefinition characters;
	
	public CharactersMapDefinition getCharacters() {
		return characters;
	}
	public void setCharacters(CharactersMapDefinition characters) {
		this.characters = characters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
