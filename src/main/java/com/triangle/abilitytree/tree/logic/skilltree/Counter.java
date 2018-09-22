package com.triangle.abilitytree.tree.logic.skilltree;

import com.triangle.abilitytree.events.UpdateDebugger;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Counter
{
	private int value;
	private int maxValue;
	private String name;
	private boolean isComplited;
	Class<? extends Event> eventType;

	//TODO List of event-listeners, binded to counters
	public Counter(String name, int maxValue, Class<? extends Event> eventType) throws IndexOutOfBoundsException
	{
		if(maxValue <= 0)
			throw new IndexOutOfBoundsException("maxValue must be greater than 0");


		this.name = name;
		this.value = 0;
		this.maxValue = maxValue;
		this.isComplited = false;
		this.eventType = eventType;
	}

	public void handleEvent(Event e)
	{

		if(eventType.isInstance(e))
			add(1);
	}

	@Override
	public String toString()
	{
		return name+": "+value+"/"+maxValue;
	}

	public void add(int i) throws IndexOutOfBoundsException
	{
		setValue(value+i);
	}

	public void setValue(int i) throws IndexOutOfBoundsException
	{
		if(isComplited)
			return;
		value = i;

		if(value >= maxValue)
			isComplited = true;

		UpdateDebugger.sendString(this.toString());
	}

	public int getValue()
	{
		return value;
	}

	public int getMaxValue()
	{
		return maxValue;
	}

	public String getName()
	{
		return name;
	}

	public boolean isComplited()
	{
		return isComplited;
	}
}
