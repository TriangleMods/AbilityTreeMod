package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class GrandChildSkill2 extends Skill
{
	public GrandChildSkill2()
	{
		addCounter(new Counter("nazi",  88));
	}

	@Override
	public String getName()
	{
		return "gc2";
	}
}
