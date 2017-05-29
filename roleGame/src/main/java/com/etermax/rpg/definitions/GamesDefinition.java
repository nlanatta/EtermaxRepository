package com.etermax.rpg.definitions;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "games")
@XmlAccessorType(XmlAccessType.FIELD)
public class GamesDefinition {

	@XmlElement(name = "game")
	private List<GameDefinition> games = null;

	public List<GameDefinition> getGames() {
		return games;
	}
	
	public GameDefinition getDefaultGame()
	{
		return games.get(0);
	}
}
