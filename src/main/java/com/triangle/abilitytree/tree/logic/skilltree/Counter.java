package com.triangle.abilitytree.tree.logic.skilltree;

public class Counter
{
	private int value;
	private int maxValue;
	private String name;
	private boolean isComplited;

	public Counter(String name, int maxValue) throws IndexOutOfBoundsException
	{
		if(maxValue <= 0)
			throw new IndexOutOfBoundsException("maxValue must be greater than 0");


		this.name = name;
		this.value = 0;
		this.maxValue = maxValue;
		this.isComplited = false;
	}


	public void add(int i) throws IndexOutOfBoundsException
	{

		setValue(value+i);
		System.out.println("New counter value: "+name+"="+value);
	}

	public void setValue(int i) throws IndexOutOfBoundsException
	{
		if(isComplited)
			return;
		value = i;

		if(value >= maxValue)
			isComplited = true;
	}

	public int getValue()
	{
		return value;
	}

	public int getMaxValue()
	{
		return maxValue;
	}

	public String getName()
	{
		return name;
	}

	public boolean isComplited()
	{
		return isComplited;
	}
}
