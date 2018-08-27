package com.triangle.abilitytree.dto;

public class SkillDTOMock implements ISkillDTO
{

	CounterDTOMock counter;
	boolean avaliable;

	public SkillDTOMock()
	{
		counter = new CounterDTOMock();
		avaliable = true;
	}

	public void setValue(int value)
	{
		counter.setValue(value);
	}

	public void setAvaliable(boolean value)
	{
		avaliable = value;
	}

	@Override
	public int getId()
	{
		return 0;
	}

	@Override
	public String getName()
	{
		return "Тестовый скилл";
	}

	@Override
	public String[] getRewards()
	{
		return new String[]{"Теперь ты четкий пацан","Урок +5"};
	}

	@Override
	public ICounterDTO[] getCounters()
	{
		return new ICounterDTO[]{counter};
	}

	@Override
	public boolean isComplited()
	{
		return counter.isComplited();
	}

	@Override
	public boolean isAvaliable()
	{
		return avaliable;
	}
}
