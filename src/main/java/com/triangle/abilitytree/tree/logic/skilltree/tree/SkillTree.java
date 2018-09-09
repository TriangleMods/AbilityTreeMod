package com.triangle.abilitytree.tree.logic.skilltree.tree;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Util;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills.RootSkill;

import java.util.ArrayList;

public class SkillTree
{
	private RootSkill root;

	public Skill getRootSkill()
	{
		return root;
	}

	public SkillTree()
	{
		root = new RootSkill();
	}

	public SkillTree(String serializedData)
	{
		this();

		String[] countersData = serializedData.split(";");
		ArrayList<String> modCounters = Util.getOnlyStartedWithAndCut(countersData, this.getName()+".");

		root.init(modCounters);

	}

	//TODO make abstract
	public String getName()
	{
		return "sample";
	}

	//TODO @ at the end of line
	public String serialize()
	{
		StringBuilder builder = new StringBuilder("");
		serialize(root, builder);
		//int length = builder.length();
		//return builder.replace(length-1,length,"@").toString();
		return builder.toString();
	}

	void serialize(Skill skill, StringBuilder builder)
	{
		for (Counter counter : skill.getCounters())
		{
			builder.append(this.getName() +'.'+ skill.getName() +'.'+ counter.getName() +':'+counter.getValue() +';');
		}


		if(skill.hasChildren())
			for (Skill childSkill : skill.getChildSkills())
			{
				serialize(childSkill,builder);
			}
	}

}
