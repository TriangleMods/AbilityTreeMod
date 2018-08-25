package com.triangle.abilitytree.trainings.jump;

import com.triangle.abilitytree.base.Training;

public class JumpTraining extends Training
{
	public JumpTraining()
	{
		super("Стать аниме", "Мечта миллионов");
		addReward(new JumpReward());
		addTrainingEventHandler(new JumpHandler(3));
	}


}
