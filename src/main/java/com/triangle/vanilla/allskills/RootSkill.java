package com.triangle.vanilla.allskills;

import com.triangle.abilitytree.tree.Skill;

public class RootSkill extends Skill
{
	public RootSkill()
	{
		setName("Root");
		setCoord(0,0);
		addChild(new JumpSkill1());

	}
}
