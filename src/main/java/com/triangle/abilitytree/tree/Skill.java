package com.triangle.abilitytree.tree;


import net.minecraftforge.fml.common.eventhandler.Event;

import java.awt.*;
import java.util.ArrayList;

//DOC_ME
public abstract class Skill
{
	private ArrayList<Skill> childSkills = null;
	private boolean hasChildren = false;

	private ArrayList<Counter> counters;
	private ArrayList<Reward> rewards;

	private String name;
	private Point coord;

	SkillInitChecker initData = new SkillInitChecker();

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
		//=====[  skill init tests   ]=====
		if(!this.initData.isInitializedProperly())
			System.err.println("### ERROR: Skill isn't initialized properly: \n name: "+this.name+"\n coord: "+this.coord);
		//============

		//TODO не передавать уже использованные счетчики
		//Получили список всех счетчиков, принадлежащих этому скиллу
		ArrayList<String> mySkillCounterData = Util.getOnlyStartedWithAndCut(countersData,this.getName()+".");
		//TODO удалять из списка инициализированные


		for (Counter counter : counters)
		{
			String delete = null;
			for (String s : mySkillCounterData)
			{
				if(s.indexOf(counter.getName()+":")==0)
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
			influenceOnEvent(e);

			if(childSkills != null)
			for (Skill childSkill : childSkills)
				childSkill.passEvent(e);
		}
		else
			this.handleEvent(e);
	}

	protected void influenceOnEvent(Event e)
	{
		for (Reward reward : rewards) {
			reward.tryInfluenceOnEvent(e);
		}
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

	protected void addCounter(Counter counter)
	{
		this.counters.add(counter);
	}

	protected void setCoord(int x, int y)
	{
		coord = new Point(x, y);
		initData.setCoord();
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

	public ArrayList<Skill> getAllChildSkills()
	{
		if(childSkills != null)
		{
			ArrayList<Skill> result = new ArrayList<>();
			result.addAll(childSkills);
			for (Skill childSkill : childSkills)
			{
				ArrayList<Skill> tmp = childSkill.getAllChildSkills();
				if(tmp != null)
					result.addAll(tmp);
			}
			return result;
		}
		return null;
	}

	protected void setName(String name)
	{
		this.name = name;
		initData.setName();
	}

	public String getName()
	{
		return name;
	}

	public void addChild(Skill child)
	{
		if(!hasChildren)
		{
			hasChildren = true;
			childSkills = new ArrayList<>();
		}
		childSkills.add(child);
	}

	public ArrayList<Reward> getRewards() {
		return rewards;
	}

	protected void addReward(Reward reward)
	{
		rewards.add(reward);
	}
}
