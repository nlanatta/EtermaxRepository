package com.etermax.rpg.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.etermax.rpg.exceptions.CharacterNotFoundException;

public class Game {

	private String id;
	private String name;
	private ArrayList<Character> characters;
	private HashMap<String, Character> charactersMap;
	private Rules rules;

	public Game() {
	}

	public Game(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rules getRules() {
		return rules;
	}

	public void setRules(Rules rules) {
		this.rules = rules;
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
		initializeCharactersMap();
	}
	
	public void initializeCharactersMap() {
		charactersMap = new HashMap<String, Character>(); 
		for (Character character: characters)
		{
			charactersMap.put(character.getId(), character);
		}
	}

	public Character getCharacterById(String id) throws CharacterNotFoundException
	{
		return charactersMap.get(id);
	}
}