package com.triangle.abilitytree.proxy;

import com.triangle.abilitytree.capabilities.SkillTreeListStorage;
import com.triangle.abilitytree.capabilities.ISkillTreeList;
import com.triangle.abilitytree.events.EventProcessor;
import com.triangle.abilitytree.capabilities.CapabilityHandler;
import com.triangle.abilitytree.tree.SkillTreeList;
import com.triangle.abilitytree.tree.SkillTreeRegistry;
import com.triangle.vanilla.VanillaSkillTree;
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
		System.out.println("### PREINIT");
		simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("abilityTreeChannel");
	}


	public void init()
	{
		System.out.println("### INIT");
		CapabilityManager.INSTANCE.register(ISkillTreeList.class, new SkillTreeListStorage(), SkillTreeList.class);
		MinecraftForge.EVENT_BUS.register(new EventProcessor());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
	}


	public void postInit()
	{
		System.out.println("### POSTINIT");
	}
}
