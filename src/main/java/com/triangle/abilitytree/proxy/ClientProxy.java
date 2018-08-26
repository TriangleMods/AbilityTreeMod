package com.triangle.abilitytree.proxy;


import com.triangle.abilitytree.keys.KeyHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	public void preInit()
	{
		super.preInit();
	}


	public void init()
	{
		super.init();
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
	}


	public void postInit()
	{
		super.postInit();
	}
}
