package com.triangle.abilitytree.tree.capabilities;

import com.triangle.abilitytree.AbilityTreeMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler
{
	public static final ResourceLocation SKILL_TREE_CAPABILITY = new ResourceLocation(AbilityTreeMod.MODID, "skilltree");

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{

		if (!(event.getObject() instanceof EntityPlayer)) return;

		System.err.println("###   ATTACH   ###");
		event.addCapability(SKILL_TREE_CAPABILITY, new SkillTreeProvider());
		System.err.println("###   Added    ###");
	}
}
