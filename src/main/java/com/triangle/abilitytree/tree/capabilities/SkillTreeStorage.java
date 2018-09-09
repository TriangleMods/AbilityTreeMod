package com.triangle.abilitytree.tree.capabilities;

import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class SkillTreeStorage implements Capability.IStorage<ISkillTree>
{
	@Override
	public NBTBase writeNBT(Capability<ISkillTree> capability, ISkillTree instance, EnumFacing side)
	{
		System.out.print("###  WRITE TO NBT");
		return  new NBTTagString(instance.getDataAsString());
		//return new NBTTagString(instance.getDataAsString());
	}

	@Override
	public void readNBT(Capability<ISkillTree> capability, ISkillTree instance, EnumFacing side, NBTBase nbt)
	{
		System.out.print("###  READ FROM NBT");
		instance.setDataFromString(((NBTTagString)nbt).getString());
		//instance.setDataFromString(((NBTTagString)nbt).getString());
	}
}
