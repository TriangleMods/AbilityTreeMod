package com.triangle.abilitytree.proxy;

import com.triangle.abilitytree.dto.StaticField;
import com.triangle.abilitytree.events.EventProcessor;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy
{

	public void preInit()
	{

	}


	public void init()
	{
		MinecraftForge.EVENT_BUS.register(new EventProcessor());
	}


	public void postInit()
	{

	}
}
