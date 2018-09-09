package com.triangle.abilitytree.tree.logic.skilltree.tree.skills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Util;

import java.util.ArrayList;

//TODO надо все закомментить

public abstract class Skill
{
	private ArrayList<Skill> childSkills = null;
	private boolean hasChildren = false;

	private ArrayList<Counter> counters;

	protected Skill()
	{
		this.hasChildren = false;
		this.childSkills = null;

		//TODO оздавать не всегда
		this.counters = new ArrayList<>();
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


	protected Skill addCounter(Counter counter)
	{
		this.counters.add(counter);
		return this;
	}

	public ArrayList<Counter> getCounters()
	{
		return counters;
	}


	public abstract String getName();

	public boolean hasChildren()
	{
		return hasChildren;
	}

	public ArrayList<Skill> getChildSkills()
	{
		return childSkills;
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

	/*
	 protected  Skill ()
	{
		return this;
	}*/
}
