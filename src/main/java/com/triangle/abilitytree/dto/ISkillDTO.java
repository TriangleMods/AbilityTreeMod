package com.triangle.abilitytree.dto;

public interface ISkillDTO
{
	int getId();
	String getName();
	String[] getRewards();
	ICounterDTO[] getCounters();
	boolean isComplited();
	boolean isAvaliable();
}
