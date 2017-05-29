package com.etermax.rpg.config;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.etermax.rpg.definitions.CharactersDefinition;
import com.etermax.rpg.definitions.GamesDefinition;
import com.etermax.rpg.factory.CharacterFactory;
import com.etermax.rpg.model.Rules;
import com.etermax.rpg.services.GameService;

@Component
public class GameConfiguration {

	private CharacterFactory characterFactory;

	@Autowired
	public void setCharacterFactory(CharacterFactory characterFactory) {
		this.characterFactory = characterFactory;
		characters();
	}

	private GameService gameService;

	@Autowired
	public void setGameFactory(GameService gameFactory) {
		this.gameService = gameFactory;
		rules();
		games();
	}

	public GameConfiguration() {
	}

	public void games() {
		String fileName = "resources/games.xml";
		File file = null;
		try {
			String resourceLocation = ResourceUtils.CLASSPATH_URL_PREFIX + fileName;
			String URL = ResourceUtils.getURL(resourceLocation).getPath();
			file = ResourceUtils.getFile(URL);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(GamesDefinition.class);
		} catch (JAXBException e) {

			e.printStackTrace();
		}

		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {

			e.printStackTrace();
		}
		GamesDefinition games = null;
		try {
			games = (GamesDefinition) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println(games);

		gameService.setGamesDefinition(games);
	}

	public void characters() {
		String fileName = "resources/definitions.xml";
		File file = null;
		try {
			String resourceLocation = ResourceUtils.CLASSPATH_URL_PREFIX + fileName;
			String URL = ResourceUtils.getURL(resourceLocation).getPath();
			file = ResourceUtils.getFile(URL);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(CharactersDefinition.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		CharactersDefinition characters = null;
		try {
			characters = (CharactersDefinition) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println(characters);

		characterFactory.setCharactersDefinition(characters);
	}

	public void rules() {
		String fileName = "resources/rules.xml";
		File file = null;
		try {
			String resourceLocation = ResourceUtils.CLASSPATH_URL_PREFIX + fileName;
			String URL = ResourceUtils.getURL(resourceLocation).getPath();
			file = ResourceUtils.getFile(URL);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(Rules.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		Unmarshaller jaxbUnmarshaller = null;
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		Rules rules = null;
		try {
			rules = (Rules) jaxbUnmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		System.out.println(rules);

		gameService.setRulesDefinition(rules);
	}
}
