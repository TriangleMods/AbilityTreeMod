package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

public class FatherSkill2 extends Skill
{
	public FatherSkill2()
	{
		addChild(new ChildSkill1());
		addChild(new ChildSkill2());

		addCounter(new Counter("send",  7));
		addCounter(new Counter("nudes",  28));
	}

	@Override
	public String getName()
	{
		return "f2";
	}
}
