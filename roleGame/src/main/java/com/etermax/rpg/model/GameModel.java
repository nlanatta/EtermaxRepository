package com.etermax.rpg.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etermax.rpg.exceptions.GameNotFoundException;
import com.etermax.rpg.services.RedisServices;
import com.etermax.rpg.utils.JsonGameUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GameModel {

	@Autowired
	private final RedisServices redisServices = null;

	public void saveGame(Game game) {
		redisServices.setValue(game.getId(), JsonGameUtils.transformGameToJasonString(game));
	}

	public Game loadGame(String gameId) throws GameNotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = (String) redisServices.getValue(gameId);
		Game game = null;
		try {
			game = mapper.readValue(jsonInString, Game.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (game == null) {
			throw new GameNotFoundException(gameId);
		}
		return game;
	}

	public void deleteGame(String gameId) {

	}
}