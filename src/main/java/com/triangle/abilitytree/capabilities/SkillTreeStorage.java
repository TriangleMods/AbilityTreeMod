package com.triangle.abilitytree.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

//DOC_ME
public class SkillTreeStorage implements Capability.IStorage<ISkillTree>
{
	@Override
	public NBTBase writeNBT(Capability<ISkillTree> capability, ISkillTree instance, EnumFacing side)
	{
		return  new NBTTagString(instance.getDataAsString());
	}

	@Override
	public void readNBT(Capability<ISkillTree> capability, ISkillTree instance, EnumFacing side, NBTBase nbt)
	{
		instance.setDataFromString(((NBTTagString)nbt).getString());
	}
}
