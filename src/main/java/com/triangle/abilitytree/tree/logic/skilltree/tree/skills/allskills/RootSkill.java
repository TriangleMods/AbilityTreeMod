package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class RootSkill extends Skill
{
	public RootSkill()
	{
		setName("Root");
		addChild(new JumpSkill1());
	}



	@Override
	public String getName()
	{
		return "root";
	}
}
