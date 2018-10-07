package com.triangle.abilitytree.capabilities;

import net.minecraft.nbt.*;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class SkillTreeListStorage implements Capability.IStorage<ISkillTreeList>
{
	@Override
	public NBTBase writeNBT(Capability<ISkillTreeList> capability, ISkillTreeList instance, EnumFacing side)
	{
		return  new NBTTagString(instance.getDataAsString());
	}

	@Override
	public void readNBT(Capability<ISkillTreeList> capability, ISkillTreeList instance, EnumFacing side, NBTBase nbt)
	{
		instance.setDataFromString(((NBTTagString)nbt).getString());
	}
}
