/*
package com.triangle.abilitytree.dto;

public class Button
{
	String name;
	ISkillDTO skillDTO;

	public Button(ISkillDTO skillDTO)
	{
		//Нельзя использовать static field
		//Только skillDTO
		this.skillDTO = skillDTO;
		this.name = skillDTO.getName();
	}

	public void drawAvaliable()
	{
		//отображение кнопки напрямую зависит от состояния SkillDTO
		System.out.println("Button "+(skillDTO.isAvaliable() ? "IS" : "ISN'T")+" avaliable");
	}

	public void drawCounter()
	{
		for (ICounterDTO counter : skillDTO.getCounters())
		{
			System.out.println(   counter.getValue() + "/" + counter.getMaxValue()   );
		}

	}
}
*/