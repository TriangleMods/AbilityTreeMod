package com.triangle.abilitytree.tree;

public class SkillTreeData
{
	private String modId;
	private String treeName;

	public SkillTreeData(String treeName)
	{
		this.treeName = treeName;
	}

	public SkillTreeData(String modid, String treeName)
	{
		this.modId = modid;
		this.treeName = treeName;
	}

	public void setModId(String modId)
	{
		this.modId = modId;
	}

	public String getModId()
	{
		return modId;
	}

	public String getTreeName()
	{
		return treeName;
	}
}
