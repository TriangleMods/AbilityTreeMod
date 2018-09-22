package com.triangle.abilitytree.events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class UpdateDebugger
{

	public static void sendString(String s)
	{

		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			return;

		Minecraft.getMinecraft().player.sendChatMessage(s);
	}
}
