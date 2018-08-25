package com.triangle.abilitytree.rewards;

public class Reward implements IReward
{
	protected final String description;

	public Reward(String description)
	{
		this.description = description;
	}

	@Override
	public String getDescription()
	{
		return description;
	}
}
