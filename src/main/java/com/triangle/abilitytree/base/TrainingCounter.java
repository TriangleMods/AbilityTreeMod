package com.triangle.abilitytree.base;

import net.minecraft.entity.player.EntityPlayer;

public class TrainingCounter
{
	int value = 0;
	final int target;
	String description;
	boolean visible = true;

	public TrainingCounter(int target, String description) throws IndexOutOfBoundsException
	{
		if(target <= 0)
			throw new IndexOutOfBoundsException("Target value must be larger than zero");

		this.target = target;
		this.description = description;
	}

	public TrainingCounter setVisible(boolean visible)
	{
		this.visible = visible;
		return this;
	}

	public boolean isComplited()
	{
		return getCurrentValue() >= getTargetValue();
	}

	public boolean isVisible()
	{
		return visible;
	}

	public String getDescription()
	{
		return description;
	}

	public int getTargetValue()
	{
		return target;
	}

	public int getCurrentValue()
	{
		return value;
	}

	public void addValue(EntityPlayer player)
	{
		addValue(1, player);
	}


	public void addValue(int i, EntityPlayer player)
	{
		value+=i;
	}

	public void resetValue()
	{
		value = 0;
	}


}
