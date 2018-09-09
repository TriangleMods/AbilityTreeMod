package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class FatherSkill1 extends Skill
{
	public FatherSkill1()
	{
		addCounter(new Counter("hate",  15));
	}

	@Override
	public String getName()
	{
		return "f1";
	}
}
