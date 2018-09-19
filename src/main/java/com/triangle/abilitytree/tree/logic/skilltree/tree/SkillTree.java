package com.triangle.abilitytree.tree.logic.skilltree.tree;

import com.triangle.abilitytree.tree.capabilities.ISkillTree;
import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Util;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills.RootSkill;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

public class SkillTree implements ISkillTree
{
	private RootSkill root = new RootSkill();

	public Skill getRootSkill()
	{
		return root;
	}


	/*public SkillTree(String serializedData)
	{
		setDataFromString(serializedData);
	}*/

	@Override
	public String getDataAsString()
	{
		//FIXME бля
		//return "oh, hi mark";
		StringBuilder builder = new StringBuilder("");
		serialize(root, builder);
		//int length = builder.length();
		//return builder.replace(length-1,length,"@").toString();
		return builder.toString();
	}

	@Override
	public void setDataFromString(String serializedData)
	{

		String[] countersData = serializedData.split(";");
		ArrayList<String> modCounters = Util.getOnlyStartedWithAndCut(countersData, this.getName()+".");

		root.init(modCounters);

		System.out.println("###   INIT: "+serializedData);
	}

	//TODO make abstract
	public String getName()
	{
		return "sample";
	}

	@Override
	public void passEvent(Event e)
	{
		System.out.println("### event pass on server: "+Minecraft.getMinecraft().world.isRemote);
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
