package com.triangle.abilitytree.events;

import com.triangle.abilitytree.capabilities.SkillTreeListProvider;
import com.triangle.abilitytree.messaging.TreeDataMessageToClient;
import com.triangle.abilitytree.proxy.CommonProxy;
import com.triangle.abilitytree.capabilities.SkillTreeExtractor;
import com.triangle.abilitytree.capabilities.ISkillTreeList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventProcessor
{
	public void sendSyncMessageWithTreeDataToClient(PlayerEvent event)
	{
		ISkillTreeList skillTree = SkillTreeExtractor.getAllSkillTrees(event.player);

		TreeDataMessageToClient msg = new TreeDataMessageToClient(skillTree);
		CommonProxy.simpleNetworkWrapper.sendTo(msg, (EntityPlayerMP)event.player);


	}


	@SubscribeEvent
	public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event)
	{
		sendSyncMessageWithTreeDataToClient(event);
	}

	@SubscribeEvent
	public void onPlayerChangesDimension(PlayerEvent.PlayerChangedDimensionEvent event)
	{
		sendSyncMessageWithTreeDataToClient(event);
	}

	@SubscribeEvent
	public void onPlayerRespawns(PlayerEvent.PlayerRespawnEvent event)
	{
		sendSyncMessageWithTreeDataToClient(event);
	}

	@SubscribeEvent
	public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
	{
		ISkillTreeList skillTree = SkillTreeExtractor.getAllSkillTrees(event.getEntityPlayer());
		ISkillTreeList oldSkillTree = event.getOriginal().getCapability(SkillTreeListProvider.SKILL_TREE_CAPABILITY, null);
		skillTree.setDataFromString(oldSkillTree.getDataAsString());

	}




	@SubscribeEvent
	public void onBonemealEvent(BonemealEvent event)
	{
		SkillTreeExtractor.passEvent(event);
	}

	@SubscribeEvent
	public void onFillBucketEvent(FillBucketEvent event)
	{
		SkillTreeExtractor.passEvent(event);
	}

	@SubscribeEvent
	public void onJumpEvent(LivingEvent.LivingJumpEvent event)
	{
		SkillTreeExtractor.passEvent(event);
	}

	@SubscribeEvent
	public void onArrowLooseEvent(ArrowLooseEvent event)
	{
		SkillTreeExtractor.passEvent(event);
	}
}
