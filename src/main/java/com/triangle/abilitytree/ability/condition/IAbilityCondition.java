package com.triangle.abilitytree.ability.condition;

public interface IAbilityCondition
{
	boolean isComplited();
	boolean isVisible();

	String getDescription();

	int getTargetValue();
	int getCurrentValue();
	boolean addToValue();
	boolean addToValue(int i);
	void resetValue();
}
