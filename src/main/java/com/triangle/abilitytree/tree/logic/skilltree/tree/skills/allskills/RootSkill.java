package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;

import java.util.ArrayList;

public class RootSkill extends Skill
{
	public RootSkill()
	{
		setName("Root");
		setCoord(0,0);
		addChild(new JumpSkill1());

	}
}
