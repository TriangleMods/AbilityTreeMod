package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class ChildSkill2 extends Skill
{
	public ChildSkill2()
	{
		addChild(new GrandChildSkill2());
		addChild(new GrandChildSkill3());

		addCounter(new Counter("drama",  4));
	}

	@Override
	public String getName()
	{
		return "c2";
	}
}
