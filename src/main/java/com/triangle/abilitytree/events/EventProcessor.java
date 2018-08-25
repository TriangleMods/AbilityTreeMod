package com.triangle.abilitytree.events;

import com.triangle.abilitytree.base.TrainingHandler;
import com.triangle.abilitytree.base.TrainingCounter;
import com.triangle.abilitytree.base.Training;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class EventProcessor
{
	static ArrayList<Training> trackingTrainings = new ArrayList<>();

	public static void add(Training training)
	{
		trackingTrainings.add(training);
	}

	//TODO many lists to improve performance

	@SubscribeEvent
	public void onJumpEvent(LivingEvent.LivingJumpEvent event)
	{
		if(event.getEntity() instanceof EntityPlayer)
		{
			ArrayList<Training> doneTrainings = new ArrayList<>();

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
				trackingTrainings.removeAll(doneTrainings);
		}
	}
}
