package com.triangle.abilitytree.tree;

import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

//DOC_ME
public abstract class Reward implements ISerializableTreePart
{
	//TODO Проверка верной инициализации
	private String description;
	private String name;
	Class<? extends Event> eventType;
	private Boolean isCancellable = true;
	private Boolean isCancelled = false;

	public Reward(String name)
	{
		this.name = name;
	}

	@Override
	public String serializeData()
	{
		return this.name;
	}


	protected void setDescription(String description)
	{
		this.description = description;
	}

	protected void setEventType(Class<? extends Event> eventType)
	{
		this.eventType = eventType;
	}

	protected void setCancellable(Boolean isCancellable)
	{
		this.isCancellable = isCancellable;
	}

	public Boolean isCancellable()
	{
		return isCancellable;
	}

	public Boolean isCancelled()
	{
		return isCancelled;
	}

	public void tryInfluenceOnEvent(Event e)
	{
		if(eventType.isInstance(e))
			influenceOnEvent(e);
	}

	protected abstract void influenceOnEvent(Event e);

	public String getDescription() {
		return this.description;
	}
	public String getName(){return this.name;}
}
