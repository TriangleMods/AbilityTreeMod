package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class GrandChildSkill1 extends Skill
{
	public GrandChildSkill1()
	{
		addCounter(new Counter("test",  5));
	}

	@Override
	public String getName()
	{
		return "gc1";
	}
}
