package com.triangle.abilitytree.tree;

import com.triangle.abilitytree.capabilities.ISkillTreeList;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

public class SkillTreeList implements ISkillTreeList
{
	final ArrayList<SkillTree> skillTrees;

	public SkillTreeList()
	{
		System.out.println("ALL SKILLS DEFAULTS LOADED FROM REGISTY!");
		skillTrees = SkillTreeRegistry.getDefaultSkillTreeInstances();
	}


	@Override
	public String getDataAsString()
	{
		System.out.println( "Found "+skillTrees.size()+" skills");
		StringBuilder builder = new StringBuilder();
		for (SkillTree skillTree : skillTrees)
		{
			builder.append(skillTree.getDataAsString());
		}
		System.out.println( builder.toString());
		return builder.toString();
	}


	@Override
	public void setDataFromString(String data)
	{
		for (SkillTree skillTree : skillTrees)
			skillTree.setDataFromString(data);
	}


	@Override
	public void passEvent(Event e)
	{
		for (SkillTree skillTree : skillTrees)
			skillTree.passEvent(e);
	}

	@Override
	public ArrayList<SkillTree> getSkillTrees()
	{
		return skillTrees;
	}
}
