package com.triangle.abilitytree.tree.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public class CapabilityExtractor {
    public static ISkillTree getSkillTree(EntityPlayer player)
    {
        return player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
    }
}
