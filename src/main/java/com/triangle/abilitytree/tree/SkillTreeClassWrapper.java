package com.triangle.abilitytree.tree;

public class SkillTreeClassWrapper
{
	private Class<? extends SkillTree> skillTreeClass;
	private String modid;

	public SkillTreeClassWrapper(Class<? extends SkillTree> skillTreeClass, String modid)
	{
		this.modid = modid;
		this.skillTreeClass = skillTreeClass;
	}

	public String getModid()
	{
		return modid;
	}

	public Class<? extends SkillTree> getSkillTreeClass()
	{
		return skillTreeClass;
	}
}