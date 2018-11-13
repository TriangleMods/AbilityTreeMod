package com.triangle.abilitytree.tree;


import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

//TODO проверка инициализации
public class SkillTree
{
	private String name;
	private Skill root;

	private String modid;

	protected void setModid(String modid)
	{
		this.modid = modid;
	}

	public String getModid()
	{
		return this.modid;
	}

	protected void setRootSkill(Skill root)
	{
		this.root = root;
	}

	public Skill getRootSkill()
	{
		return root;
	}


	public ArrayList<Skill> getAllSkills()
	{
		return root.getAllChildSkills();
	}

	public String serializeData()
	{
		StringBuilder builder = new StringBuilder("");
		return builder.toString();
	}

	public String getDataAsString()
	{
		StringBuilder builder = new StringBuilder("");
		serialize(root, builder);
		return builder.toString();
	}

	public void setDataFromString(String serializedData) {

		String[] countersData = serializedData.split(";");
		ArrayList<String> modCounters = Util.getOnlyStartedWithAndCut(countersData, this.getName()+".");

		root.init(modCounters);
	}

	protected void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void passEvent(Event e)
	{
		this.root.passEvent(e);
	}

	void serialize(Skill skill, StringBuilder builder)
	{
		for (Counter counter : skill.getCounters())
		{
			builder.append(this.getName() +'.'+ skill.getName() +'.'+ counter.getName() +':'+counter.getValue() +';');
		}


		if(skill.hasChildren())
			for (Skill childSkill : skill.getChildSkills())
			{
				serialize(childSkill,builder);
			}
	}


}
