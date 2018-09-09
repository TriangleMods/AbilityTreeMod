package com.triangle.abilitytree.proxy;

import com.triangle.abilitytree.dto.StaticField;
import com.triangle.abilitytree.events.EventProcessor;
import com.triangle.abilitytree.tree.capabilities.CapabilityHandler;
import com.triangle.abilitytree.tree.capabilities.ISkillTree;
import com.triangle.abilitytree.tree.capabilities.SkillTreeStorage;
import com.triangle.abilitytree.tree.logic.skilltree.tree.SkillTree;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;

public abstract class CommonProxy
{

	public void preInit()
	{

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
