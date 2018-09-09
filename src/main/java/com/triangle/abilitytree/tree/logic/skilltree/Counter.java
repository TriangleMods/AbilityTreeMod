package com.triangle.abilitytree.tree.logic.skilltree;

public class Counter
{
	private int value;
	private int maxValue;
	private String name;

	public Counter(String name, int maxValue) throws IndexOutOfBoundsException
	{
		if(maxValue <= 0)
			throw new IndexOutOfBoundsException("maxValue must be greater than 0");


		this.name = name;
		this.value = 0;
		this.maxValue = maxValue;
	}


	public void add(int i) throws IndexOutOfBoundsException
	{
		setValue(value+i);
	}

	public void setValue(int i) throws IndexOutOfBoundsException
	{
		if(i > maxValue || i < 0)
			throw new IndexOutOfBoundsException("value must be between 0 and "+maxValue+" (this.maxValue)");
		value = i;
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
		return value >= maxValue;
	}
}
