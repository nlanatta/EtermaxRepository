package com.etermax.rpg.model;

import java.awt.Point;
import java.util.List;

import com.etermax.rpg.definitions.CharacterDefinition;

public class Character implements IPlayable {
	
	private String id;
	private List<String> factions;
	private int level;
	private String type;
	private float health;
	private int rangeAttack;
	private Point position;
	private boolean death = false;
	
	public boolean isDeath() {
		return death;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	public Character()
	{		
	}
	
	public Character(CharacterDefinition characterDefinition)
	{
		factions = characterDefinition.getFactions();
		level = characterDefinition.getLevel();
		type = characterDefinition.getType();
		health = characterDefinition.getHealth();
		rangeAttack = characterDefinition.getRangeAttack();
	}

	public List<String> getFactions() {
		return factions;
	}

	public void setFactions(List<String> factions) {
		this.factions = factions;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(int health) {		
		this.health += health;
		if(this.health > 1000)
		{
			this.health = 1000;
		}
	}

	public int getRangeAttack() {
		return rangeAttack;
	}

	public void setRangeAttack(int rangeAttack) {
		this.rangeAttack = rangeAttack;
	}

	@Override
	public void heal(float heal) {
		if(!isDeath())
		{
			health += heal;
		}
		
	}

	@Override
	public void damage(float damage) {
		health -= damage;
		if(health <= 0)
		{
			setDeath(true);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
