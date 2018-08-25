package com.triangle.abilitytree.training_counters;

public interface ITrainingCounter
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
