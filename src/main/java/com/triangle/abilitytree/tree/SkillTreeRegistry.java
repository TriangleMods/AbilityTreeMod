package com.triangle.abilitytree.tree;

import java.util.ArrayList;

//Registry of skills, creates default instances for initialization
public class SkillTreeRegistry
{
	static ArrayList<SkillTreeClassWrapper> skillTreeTypes = new ArrayList<>();

	//TODO collision validation
	//TODO char blacklist validation
	public static void add(Class<? extends SkillTree> skillTreeType, String modid)
	{
		skillTreeTypes.add(new SkillTreeClassWrapper(skillTreeType, modid));
	}

	public static ArrayList<SkillTree> getDefaultSkillTreeInstances()
	{
		ArrayList<SkillTree> result = new ArrayList<>();
		for (SkillTreeClassWrapper skillTreeType : skillTreeTypes)
		{
			try
			{
				SkillTree instance = skillTreeType.getSkillTreeClass().newInstance();
				instance.setModid(skillTreeType.getModid());
				result.add(instance);
			}
			catch (InstantiationException e)
			{
				System.err.println("ERROR while loading SkillTree: all SkillTrees must have public /default/ constructor");
			}
			catch (IllegalAccessException e)
			{
				System.err.println("ERROR while loading SkillTree: all SkillTrees must have public default /constructor/");
			}
		}
		return result;
	}


}
