package com.triangle.abilitytree.tree;


import java.util.ArrayList;

//DOC_ME
public class Util
{
	//Повторяющийся код в сериализаторе


	//TODO Можно ли это оптимизировать?

	public static ArrayList<String> getOnlyStartedWithAndCut(String[] strings, String start)
	{
		ArrayList<String> result = new ArrayList<>();

		for (String string : strings)
		{
			if(string.indexOf(start) == 0)
				result.add(string.substring(start.length()));
		}

		return result;

	}

	public static ArrayList<String> getOnlyStartedWithAndCut(ArrayList<String> strings, String start)
	{
		ArrayList<String> result = new ArrayList<>();

		for (String string : strings)
		{
			if(string.indexOf(start) == 0)
				result.add(string.substring(start.length()));
		}

		return result;

	}
}
