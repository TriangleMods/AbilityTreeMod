package com.triangle.abilitytree.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SkillTreeListProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(ISkillTreeList.class)
	public static final Capability<ISkillTreeList> SKILL_TREE_CAPABILITY = null;

	private ISkillTreeList instance = SKILL_TREE_CAPABILITY.getDefaultInstance();

	public SkillTreeListProvider()
	{

	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == SKILL_TREE_CAPABILITY;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		return capability == SKILL_TREE_CAPABILITY ? SKILL_TREE_CAPABILITY.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		return SKILL_TREE_CAPABILITY.getStorage().writeNBT(SKILL_TREE_CAPABILITY, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		SKILL_TREE_CAPABILITY.getStorage().readNBT(SKILL_TREE_CAPABILITY, this.instance, null, nbt);
	}
}
