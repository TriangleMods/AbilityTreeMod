package com.triangle.abilitytree.base;


import com.triangle.abilitytree.events.EventType;
import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class TrainingHandler
{
	EventType eventType;
	protected TrainingCounter counter;


	public TrainingHandler(EventType eventType, TrainingCounter counter)
	{
		this.eventType = eventType;
		this.counter = counter;
	}

	public boolean isValidEvent(Event event)
	{
		return eventType.isCorrectClass(event);
	}

	public TrainingCounter getCounter()
	{
		return counter;
	}

	public abstract void handle(Event event);

}
