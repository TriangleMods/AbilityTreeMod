package com.triangle.abilitytree.proxy;

import com.triangle.abilitytree.dto.StaticField;
import com.triangle.abilitytree.events.EventProcessor;
import com.triangle.abilitytree.trainings.ModTrainings;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy
{

	public void preInit()
	{

	}


	public void init()
	{
		MinecraftForge.EVENT_BUS.register(new EventProcessor());
		ModTrainings.init();
	}


	public void postInit()
	{

	}
}
