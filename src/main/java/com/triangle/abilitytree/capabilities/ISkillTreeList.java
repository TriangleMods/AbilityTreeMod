package com.triangle.abilitytree.capabilities;

import com.triangle.abilitytree.tree.SkillTree;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

//default capability interface
public interface ISkillTreeList
{
	String getDataAsString();
	void setDataFromString(String data);
	void passEvent(Event e);
	ArrayList<SkillTree> getSkillTrees();
}
