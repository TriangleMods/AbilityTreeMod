package com.triangle.abilitytree.tree;

import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class Reward
{
	//TODO Проверка верной инициализации
	private String description;
	Class<? extends Event> eventType;

	protected void setDescription(String description)
	{
		this.description = description;
	}

	protected void setEventType(Class<? extends Event> eventType)
	{
		this.eventType = eventType;
	}


	public void tryInfluenceOnEvent(Event e)
	{
		if(eventType.isInstance(e))
			influenceOnEvent(e);
	}

	protected abstract void influenceOnEvent(Event e);

}
