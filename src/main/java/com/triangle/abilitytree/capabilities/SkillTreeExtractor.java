package com.triangle.abilitytree.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

//Provides simple access to SkillTreeList capability
public class SkillTreeExtractor
{
	//Getter of SkillTreeList capability
    public static ISkillTreeList getAllSkillTrees(EntityPlayer player)
    {
        return player.getCapability(SkillTreeListProvider.SKILL_TREE_CAPABILITY, null);
    }

    //Event pass wrapper
    public static void passEvent(PlayerEvent e)
    {
    	getAllSkillTrees(e.getEntityPlayer()).passEvent(e);
    }

	//Event pass wrapper
	public static void passEvent(LivingEvent e)
	{
		Entity entity = e.getEntity();
		if(entity instanceof EntityPlayer)
			getAllSkillTrees((EntityPlayer)entity).passEvent(e);
	}
}
