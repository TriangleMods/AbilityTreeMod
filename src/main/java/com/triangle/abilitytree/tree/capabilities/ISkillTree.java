package com.triangle.abilitytree.tree.capabilities;

import net.minecraftforge.fml.common.eventhandler.Event;

public interface ISkillTree
{
	String getDataAsString();
	void setDataFromString(String data);

	void passEvent(Event e);
}
