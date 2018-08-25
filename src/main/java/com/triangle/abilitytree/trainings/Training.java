package com.triangle.abilitytree.trainings;

import com.triangle.abilitytree.rewards.IReward;
import com.triangle.abilitytree.training_counters.ITrainingCounter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;

public class Training implements ITraining
{
	protected String name;
	protected String description;
	protected ArrayList<ITrainingCounter> counters;
	protected ArrayList<IReward> rewards;

	public Training(String name, String description)
	{
		this.name = name;
		this.description = description;
		counters = new ArrayList<>();
		rewards = new ArrayList<>();
	}

	public Training addReward(IReward reward)
	{
		rewards.add(reward);
		return this;
	}

	public Training addTrainingCounter(ITrainingCounter counter)
	{
		counters.add(counter);
		return this;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	@Override
	public ArrayList<ITrainingCounter> getTrainingCounters()
	{
		return counters;
	}

	@Override
	public boolean isComplited()
	{
		for (ITrainingCounter counter : counters)
			if(!counter.isComplited())
				return false;
		return true;
	}

	@Override
	public ArrayList<IReward> getRewards()
	{
		return rewards;
	}

	@Override
	public void applyRewards(EntityPlayer player)
	{
		for (IReward reward : rewards)
			player.sendMessage(new TextComponentString("You granted" + reward.getDescription()));
	}
}
