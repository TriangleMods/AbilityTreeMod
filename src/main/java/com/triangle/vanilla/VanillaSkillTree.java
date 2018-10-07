package com.triangle.vanilla;
import com.triangle.vanilla.allskills.*;

import com.triangle.abilitytree.tree.SkillTree;

public class VanillaSkillTree extends SkillTree
{
	public VanillaSkillTree()
	{
		this.setName("Vanilla");
		this.setRootSkill(new RootSkill());
	}
}
