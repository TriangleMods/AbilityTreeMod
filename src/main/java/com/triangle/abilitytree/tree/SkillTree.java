package com.triangle.abilitytree.tree;


import com.triangle.abilitytree.events.UpdateDebugger;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

//TODO проверка инициализации
public class SkillTree implements ISerializableTreePart
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

	@Override
	public String serializeData()
	{
		StringBuilder builder = new StringBuilder("");
		builder.append(this.getName());

		ArrayList<String> skillsData = new ArrayList<>();
		for (Skill skill : this.getAllSkills())
		{
			String tmp = skill.serializeData();
			if(tmp.length()>0)
				skillsData.add(tmp);
		}

		if(skillsData.size()>0)
		{
			builder.append(':');
			builder.append(String.join(";",skillsData));
		}

		return builder.toString();
	}



	public String getDataAsString()
	{
		StringBuilder builder = new StringBuilder("");
		serialize(root, builder);
		UpdateDebugger.sendString("{");
		UpdateDebugger.sendString(builder.toString());
		UpdateDebugger.sendString(serializeData());
		UpdateDebugger.sendString("}");
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
