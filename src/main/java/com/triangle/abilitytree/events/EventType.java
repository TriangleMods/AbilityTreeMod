package com.triangle.abilitytree.events;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

//DOC_ME
public enum EventType
{
	LivingJump(LivingEvent.LivingJumpEvent.class),
	AttackEntity(AttackEntityEvent.class);

	private Class<? extends Event> eventClass;

	private EventType(Class<? extends Event> cls)
	{
		this.eventClass = cls;
	}

	public boolean isCorrectClass(Event event)
	{
		return event.getClass().equals(eventClass);
	}
}
