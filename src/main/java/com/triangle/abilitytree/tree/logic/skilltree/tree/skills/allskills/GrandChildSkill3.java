package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;


import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class GrandChildSkill3 extends Skill
{
	public GrandChildSkill3()
	{
		addCounter(new Counter("test",  15));
		addCounter(new Counter("nest",  8));
	}

	@Override
	public String getName()
	{
		return "gc3";
	}
}
