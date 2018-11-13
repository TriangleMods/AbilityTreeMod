package com.triangle.vanilla.allskills;

import com.triangle.abilitytree.tree.Skill;
import com.triangle.abilitytree.tree.SkillTreeData;

public class RootSkill extends Skill
{
	public RootSkill(SkillTreeData skillTreeData)
	{
		super(skillTreeData);
		setName("Root");
		setCoord(0,0);
		addChild(new JumpSkill1(skillTreeData));

	}
}
