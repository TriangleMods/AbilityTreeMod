package com.triangle.abilitytree.dto;

public class CounterDTOMock implements ICounterDTO
{

	int value;
	final int maxValue = 10;

	public CounterDTOMock()
	{
		this.value = 0;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	@Override
	public int getValue()
	{
		return value;
	}

	@Override
	public int getMaxValue()
	{
		return maxValue;
	}

	@Override
	public String getDescription()
	{
		return "Отожмись без рук";
	}

	@Override
	public boolean isComplited()
	{
		return value >= maxValue;
	}
}
