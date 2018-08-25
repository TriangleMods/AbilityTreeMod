package com.triangle.abilitytree.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;

public class Training
{
	String name;
	String description;
	ArrayList<TrainingHandler> handlers;
	ArrayList<Reward> rewards;

	public Training(String name, String description)
	{
		this.name = name;
		this.description = description;
		handlers = new ArrayList<>();
		rewards = new ArrayList<>();


	}

	public Training addReward(Reward reward)
	{
		rewards.add(reward);
		return this;
	}

	public Training addTrainingEventHandler(TrainingHandler handler)
	{
		handlers.add(handler);
		return this;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public ArrayList<TrainingHandler> getTrainingEventHandlers()
	{
		return handlers;
	}

	public boolean isComplited()
	{
		for (TrainingHandler handler : handlers)
			if(!handler.getCounter().isComplited())
				return false;
		return true;
	}

	public ArrayList<Reward> getRewards()
	{
		return rewards;
	}

	public void applyRewards(EntityPlayer player)
	{
		for (Reward reward : rewards)
			player.sendMessage(new TextComponentString("You granted: " + reward.getDescription()));
	}

	public void checkComplited(EntityPlayer player)
	{
		if(isComplited())
			applyRewards(player);

	}
}
