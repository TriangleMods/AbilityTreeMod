package com.triangle.abilitytree.events;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

//Debug-only. Sends message to players chat
public class UpdateDebugger
{

	public static void sendString(String s)
	{

		/*if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			return;*/

		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
		{
			FMLCommonHandler.instance().getMinecraftServerInstance().sendMessage(new TextComponentString("server: "+s));
		}
		else
			Minecraft.getMinecraft().player.sendChatMessage("client: "+s);
	}
}
