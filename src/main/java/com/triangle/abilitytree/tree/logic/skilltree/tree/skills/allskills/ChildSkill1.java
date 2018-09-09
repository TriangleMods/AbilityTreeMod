package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class ChildSkill1 extends Skill
{
	public ChildSkill1()
	{
		addChild(new GrandChildSkill1());

		addCounter(new Counter("drama",  55));
		addCounter(new Counter("queen",  100));
	}

	@Override
	public String getName()
	{
		return "c1";
	}
}
