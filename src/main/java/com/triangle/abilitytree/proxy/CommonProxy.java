package com.triangle.abilitytree.proxy;

import com.triangle.abilitytree.events.EventProcessor;
import com.triangle.abilitytree.capabilities.CapabilityHandler;
import com.triangle.abilitytree.capabilities.ISkillTree;
import com.triangle.abilitytree.capabilities.SkillTreeStorage;
import com.triangle.abilitytree.tree.SkillTree;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public abstract class CommonProxy
{

	public static SimpleNetworkWrapper simpleNetworkWrapper;
	public static final byte TREE_DATA_MESSAGE_ID = 63;

	public void preInit()
	{
		simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("abilityTreeChannel");
	}


	public void init()
	{
		CapabilityManager.INSTANCE.register(ISkillTree.class, new SkillTreeStorage(), SkillTree.class);
		MinecraftForge.EVENT_BUS.register(new EventProcessor());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
	}


	public void postInit()
	{

	}
}
