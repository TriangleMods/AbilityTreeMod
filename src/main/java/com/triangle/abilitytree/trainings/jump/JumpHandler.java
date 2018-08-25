package com.triangle.abilitytree.trainings.jump;

import com.triangle.abilitytree.events.EventType;
import com.triangle.abilitytree.base.TrainingCounter;
import com.triangle.abilitytree.base.TrainingHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class JumpHandler extends TrainingHandler
{
	public JumpHandler(int count)
	{
		super(EventType.LivingJump, new TrainingCounter(count, "Нужно прыгнуть "+count+" раза"));
	}

	@Override
	public void handle(Event event)
	{
		LivingEvent.LivingJumpEvent jump = (LivingEvent.LivingJumpEvent)event;
		EntityPlayer player = (EntityPlayer)jump.getEntity();
		if(player.getEntityWorld().isRemote)
		{
			counter.addValue(player);
			player.sendMessage(new TextComponentString("Jump: "+counter.getCurrentValue()+"/"+counter.getTargetValue()));
		}
	}
}

