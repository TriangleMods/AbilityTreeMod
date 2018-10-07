package com.triangle.abilitytree.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

//DOC_ME
public class SkillTreeExtractor
{
    public static ISkillTreeList getAllSkillTrees(EntityPlayer player)
    {
        return player.getCapability(SkillTreeListProvider.SKILL_TREE_CAPABILITY, null);
    }

    public static void passEvent(PlayerEvent e)
    {
    	getAllSkillTrees(e.getEntityPlayer()).passEvent(e);
    }

	public static void passEvent(LivingEvent e)
	{
		Entity entity = e.getEntity();
		if(entity instanceof EntityPlayer)
			getAllSkillTrees((EntityPlayer)entity).passEvent(e);
	}
}
