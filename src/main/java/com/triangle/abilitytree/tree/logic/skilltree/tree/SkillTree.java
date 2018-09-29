package com.triangle.abilitytree.tree.logic.skilltree.tree;

import com.triangle.abilitytree.tree.capabilities.ISkillTree;
import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Util;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills.RootSkill;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

public class SkillTree implements ISkillTree
{
	private RootSkill root = new RootSkill();

	public Skill getRootSkill()
	{
		return root;
	}


	public String getDataAsString()
	{
		StringBuilder builder = new StringBuilder("");
		serialize(root, builder);
		return builder.toString();
	}

	public void setDataFromString(String serializedData)
	{

		String[] countersData = serializedData.split(";");
		ArrayList<String> modCounters = Util.getOnlyStartedWithAndCut(countersData, this.getName()+".");

		root.init(modCounters);
	}

	//TODO make abstract
	public String getName()
	{
		return "sample";
	}

	public void passEvent(Event e)
	{
		this.root.passEvent(e);
	}

	void serialize(Skill skill, StringBuilder builder)
	{
		for (Counter counter : skill.getCounters())
		{
			builder.append(this.getName() +'.'+ skill.getName() +'.'+ counter.getDescription() +':'+counter.getValue() +';');
		}


		if(skill.hasChildren())
			for (Skill childSkill : skill.getChildSkills())
			{
				serialize(childSkill,builder);
			}
	}


}
