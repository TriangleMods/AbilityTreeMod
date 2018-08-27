package com.triangle.abilitytree.dto;

public class StaticField
{
	static SkillDTOMock skillDTO;

	static
	{
		skillDTO = new SkillDTOMock();
	}

	public static ISkillDTO getSkill()
	{
		return skillDTO;
	}

	public static void setValue(int value)
	{
		skillDTO.setValue(value);
	}

	public static void setAvaliable(boolean value)
	{
		skillDTO.setAvaliable(value);
	}
}
