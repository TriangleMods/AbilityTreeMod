package com.triangle.abilitytree.tree;


import com.triangle.abilitytree.events.UpdateDebugger;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

//TODO проверка инициализации
public class SkillTree implements ISerializableTreePart
{
	private Skill root;

	private SkillTreeData skillTreeData;

	protected void setModid(String modid)
	{
		this.skillTreeData.setModId(modid);
	}

	protected void setData(String name)
	{
		skillTreeData = new SkillTreeData(name);
	}

	public SkillTreeData getSkillTreeData()
	{
		return skillTreeData;
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
		builder.append(this.skillTreeData.getTreeName());

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
		ArrayList<String> modCounters = Util.getOnlyStartedWithAndCut(countersData, this.skillTreeData.getTreeName()+".");

		root.init(modCounters);
	}


	public void passEvent(Event e)
	{
		this.root.passEvent(e);
	}

	void serialize(Skill skill, StringBuilder builder)
	{
		for (Counter counter : skill.getCounters())
		{
			builder.append(this.skillTreeData.getTreeName()+'.'+ skill.getName() +'.'+ counter.getName() +':'+counter.getValue() +';');
		}


		if(skill.hasChildren())
			for (Skill childSkill : skill.getChildSkills())
			{
				serialize(childSkill,builder);
			}
	}


}
