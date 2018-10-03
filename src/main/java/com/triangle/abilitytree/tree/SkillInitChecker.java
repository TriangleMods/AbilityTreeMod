package com.triangle.abilitytree.tree;

//DOC_ME
public class SkillInitChecker
{
	private Boolean name = false;
	private Boolean coord = false;

	public void setName()
	{
		name = true;
	}

	public void setCoord()
	{
		coord = true;
	}

	public Boolean getNameState()
	{
		return name;
	}

	public Boolean getCoordState()
	{
		return coord;
	}

	public Boolean isInitializedProperly()
	{
		return name && coord;
	}
}
