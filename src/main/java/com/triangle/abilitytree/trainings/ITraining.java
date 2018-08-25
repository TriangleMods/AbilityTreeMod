package com.triangle.abilitytree.trainings;

import com.triangle.abilitytree.training_counters.ITrainingCounter;
import com.triangle.abilitytree.rewards.IReward;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public interface ITraining
{
	String getName();
	String getDescription();

	ArrayList<ITrainingCounter> getTrainingCounters();
	boolean isComplited();

	ArrayList<IReward> getRewards();

	void applyRewards(EntityPlayer player);
}
