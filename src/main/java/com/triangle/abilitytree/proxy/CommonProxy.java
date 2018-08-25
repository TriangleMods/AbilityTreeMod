package com.triangle.abilitytree.proxy;

import com.triangle.abilitytree.rewards.Reward;

public abstract class CommonProxy
{

	public void preInit()
	{

	}


	public void init()
	{

	}


	public void postInit()
	{
		Reward reward = new Reward("Теперь ты пидор");

		System.err.println();
	}
}
