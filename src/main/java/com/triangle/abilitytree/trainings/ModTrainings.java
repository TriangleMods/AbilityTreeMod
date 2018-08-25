package com.triangle.abilitytree.trainings;

import com.triangle.abilitytree.events.EventProcessor;
import com.triangle.abilitytree.trainings.jump.JumpTraining;

public class ModTrainings
{
	public static void init()
	{
		EventProcessor.add(new JumpTraining());
	}
}
