package com.triangle.abilitytree.tree.logic.skilltree.tree.skills;


import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Util;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;


public abstract class Skill
{
	private ArrayList<Skill> childSkills = null;
	private boolean hasChildren = false;

	private ArrayList<Counter> counters;

	private ArrayList<String> rewards;

	private String name;

	protected Skill()
	{
		this.hasChildren = false;
		this.childSkills = null;

		//TODO создавать не всегда
		this.counters = new ArrayList<>();

		this.rewards = new ArrayList<>();
	}

	public void init(ArrayList<String> countersData)
	{
		//TODO не передавать уже использованные счетчики
		//Получили список всех счетчиков, принадлежащих этому скиллу
		ArrayList<String> mySkillCounterData = Util.getOnlyStartedWithAndCut(countersData,this.getName()+".");
		//TODO удалять из списка инициализированные


		for (Counter counter : counters)
		{
			String delete = null;
			for (String s : mySkillCounterData)
			{
				if(s.indexOf(counter.getDescription()+":")==0)
				{
					counter.setValue(Integer.parseInt(s.split(":")[1]));
					delete = s;
					break;
				}
			}
			//TODO чекнуть копируется ли
			if(delete != null)
				mySkillCounterData.remove(delete);
		}

		if(hasChildren)
			for (Skill childSkill : childSkills)
			{
				childSkill.init(countersData);//Включает в себя уже использованные
			}
	}

	public void passEvent(Event e)
	{
		System.out.println("Event passed to "+this.name);

		if(this.isComplited())
		{
			if(childSkills != null)
			for (Skill childSkill : childSkills)
				childSkill.passEvent(e);
		}
		else
			this.handleEvent(e);
	}

	protected void handleEvent(Event e)
	{
		for (Counter counter : counters)
		{
			if(!counter.isComplited())
				counter.handleEvent(e);
		}

	}


	public boolean isComplited()
	{
		for (Counter counter : counters)
			if(!counter.isComplited())
				return false;
		return true;
	}

	protected Skill addCounter(Counter counter)
	{
		this.counters.add(counter);
		return this;
	}

	public ArrayList<Counter> getCounters(){
		return counters;
	}


	public boolean hasChildren()
	{
		return hasChildren;
	}


	public ArrayList<Skill> getChildSkills(){
		return childSkills;
	}

	protected Skill setName(String name)
	{
		this.name = name;
		return this;
	}

	public String getName()
	{
		return name;
	}

	public Skill addChild(Skill child)
	{
		if(!hasChildren)
		{
			hasChildren = true;
			childSkills = new ArrayList<>();
		}
		childSkills.add(child);
		return this;
	}

	public ArrayList<String> getRewards() {
		return rewards;
	}

	protected Skill addReward(String reward)
	{
		rewards.add(reward);
		return this;
	}
}
