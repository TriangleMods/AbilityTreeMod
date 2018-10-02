package com.triangle.abilitytree.capabilities;

import com.triangle.abilitytree.tree.Skill;
import net.minecraftforge.fml.common.eventhandler.Event;

public interface ISkillTree
{
	String getDataAsString();
	void setDataFromString(String data);
	void passEvent(Event e);
	Skill getRootSkill();
}
