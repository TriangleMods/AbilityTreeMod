package com.triangle.vanilla;

import com.triangle.abilitytree.tree.SkillTreeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = VanillaAbilityTreeMod.MODID, name = VanillaAbilityTreeMod.NAME, version = VanillaAbilityTreeMod.VERSION)
public class VanillaAbilityTreeMod
{
    public static final String MODID = "vanillaabilitytree";
    public static final String NAME = "Vanilla Ability Tree";
    public static final String VERSION = "0.0.1";



    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        SkillTreeRegistry.add(VanillaSkillTree.class, this.MODID);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {



    }
}
