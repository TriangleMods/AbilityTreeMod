package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import com.triangle.abilitytree.tree.logic.skilltree.Counter;

public class RootSkill extends Skill
{
	public RootSkill()
	{
		addChild(new FatherSkill1());
		addChild(new FatherSkill2());

		addCounter(new Counter("jump", 50));
	}

	@Override
	public String getName()
	{
		return "root";
	}
}
