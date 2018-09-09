package com.triangle.abilitytree.events;

import com.triangle.abilitytree.dto.StaticField;
import com.triangle.abilitytree.tree.capabilities.ISkillTree;
import com.triangle.abilitytree.tree.capabilities.SkillTreeProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ArrayList;

public class EventProcessor
{
	//static ArrayList<Training> trackingTrainings = new ArrayList<>();

	/*public static void add(Training training)
	{
		trackingTrainings.add(training);
	}*/

	//TODO many lists to improve performance

	@SubscribeEvent
	public void onPlayerLogsIn(PlayerEvent.PlayerLoggedInEvent event)
	{
		EntityPlayer player = event.player;
		System.err.println("###   LOGIN   ###");
		ISkillTree skillTree = player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);

		player.sendMessage(new TextComponentString(skillTree.getDataAsString()));
	}

	@SubscribeEvent
	public void onJumpEvent(LivingEvent.LivingJumpEvent event)
	{
		Entity e = event.getEntity();
		if(e instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)e;
			ISkillTree skillTree = player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);

			player.sendMessage(new TextComponentString(skillTree.getDataAsString()));

			/*ArrayList<Training> doneTrainings = new ArrayList<>();

			if(event.getEntity().world.isRemote)
				StaticField.setValue(StaticField.getSkill().getCounters()[0].getValue()+1);

			for (Training training : trackingTrainings)
			{
				for (TrainingHandler handler : training.getTrainingEventHandlers())
				{
					TrainingCounter counter = handler.getCounter();
					if(!counter.isComplited())
					{
						if(handler.isValidEvent(event))
						{
							handler.handle(event);

							if(counter.isComplited())
								if(training.isComplited())
								{
									//TODO universal entity casting
									training.checkComplited((EntityPlayer) event.getEntity());
									doneTrainings.add(training);
								}
						}
					}
				}
			}

			if(doneTrainings.size()>0)
				trackingTrainings.removeAll(doneTrainings);*/
		}
	}
}
