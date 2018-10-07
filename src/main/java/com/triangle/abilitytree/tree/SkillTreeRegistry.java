package com.triangle.abilitytree.tree;

import java.util.ArrayList;

public class SkillTreeRegistry
{
	static ArrayList<Class<? extends SkillTree>> skillTreeTypes = new ArrayList<>();

	//TODO проверка на однинаковые имена
	//TODO проверка на специальные символы
	public static void add(Class<? extends SkillTree> skillTreeType)
	{
		System.out.println("SKILL "+skillTreeType.getName()+" ADDED TO REGISTRY!");
		skillTreeTypes.add(skillTreeType);
	}

	public static ArrayList<SkillTree> getDefaultSkillTreeInstances()
	{
		ArrayList<SkillTree> result = new ArrayList<>();
		for (Class<? extends SkillTree> skillTreeType : skillTreeTypes)
		{
			try
			{
				result.add(skillTreeType.newInstance());
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
