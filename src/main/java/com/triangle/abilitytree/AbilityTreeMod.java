package com.triangle.abilitytree;

import com.triangle.abilitytree.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AbilityTreeMod.MODID, name = AbilityTreeMod.NAME, version = AbilityTreeMod.VERSION)
public class AbilityTreeMod
{
    public static final String MODID = "abilitytree";
    public static final String NAME = "Ability Tree Mod";
    public static final String VERSION = "0.0.6";

    @SidedProxy(clientSide = "com.triangle.abilitytree.proxy.ClientProxy", serverSide = "com.triangle.abilitytree.proxy.ServerProxy")
    private static CommonProxy proxy;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();


    }
}
