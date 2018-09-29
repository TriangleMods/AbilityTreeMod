package com.triangle.abilitytree.tree.capabilities;

import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraftforge.fml.common.eventhandler.Event;

public interface ISkillTree
{
	String getDataAsString();
	void setDataFromString(String data);
	void passEvent(Event e);
	Skill getRootSkill();
}
