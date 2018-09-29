package com.triangle.abilitytree.events;

import com.triangle.abilitytree.messaging.TreeDataMessageToClient;
import com.triangle.abilitytree.proxy.CommonProxy;
import com.triangle.abilitytree.tree.capabilities.CapabilityExtractor;
import com.triangle.abilitytree.tree.capabilities.ISkillTree;
import com.triangle.abilitytree.tree.capabilities.SkillTreeProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventProcessor
{
    //TODO удалить комметны
	@SubscribeEvent
	public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event)
	{
		ISkillTree skillTree = CapabilityExtractor.getSkillTree(event.player);
		// player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);

		TreeDataMessageToClient msg = new TreeDataMessageToClient(skillTree);
		CommonProxy.simpleNetworkWrapper.sendTo(msg, (EntityPlayerMP)event.player);

	}

	@SubscribeEvent
	public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
	{
		//EntityPlayer player = event.getEntityPlayer();
		ISkillTree skillTree = CapabilityExtractor.getSkillTree(event.getEntityPlayer());
        //player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
		ISkillTree oldSkillTree = event.getOriginal().getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);

		skillTree.setDataFromString(oldSkillTree.getDataAsString());
	}

	@SubscribeEvent
	public void onBonemealEvent(BonemealEvent event)
	{
		//EntityPlayer player = event.getEntityPlayer();
		//ISkillTree skillTree = player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
        ISkillTree skillTree = CapabilityExtractor.getSkillTree(event.getEntityPlayer());
		skillTree.passEvent(event);
	}

	@SubscribeEvent
	public void onFillBucketEvent(FillBucketEvent event)
	{
		//EntityPlayer player = event.getEntityPlayer();
		//ISkillTree skillTree = player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
        ISkillTree skillTree = CapabilityExtractor.getSkillTree(event.getEntityPlayer());
		skillTree.passEvent(event);
	}

	@SubscribeEvent
	public void onJumpEvent(LivingEvent.LivingJumpEvent event)
	{
		Entity e = event.getEntity();
		if(e instanceof EntityPlayer)
		{
			//EntityPlayer player = (EntityPlayer)e;
			//ISkillTree skillTree = player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
            ISkillTree skillTree = CapabilityExtractor.getSkillTree((EntityPlayer)e);
			skillTree.passEvent(event);
		}
	}
}
