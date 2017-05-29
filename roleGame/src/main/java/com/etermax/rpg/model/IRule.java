package com.etermax.rpg.model;

public interface IRule {
	public boolean canAttack(String type);
	public boolean isInRange(int range);
}
