package com.etermax.rpg.utils;

import com.etermax.rpg.model.Game;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGameUtils {
	public static String transformGameToJasonString(Game game)
	{
		ObjectMapper mapper = new ObjectMapper();

		//Object to JSON in String
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(game);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonInString;
	}
}
