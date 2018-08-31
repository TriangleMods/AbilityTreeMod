package com.triangle.abilitytree.keys;

import com.triangle.abilitytree.guiexample.advancedGuiScreen;
import com.triangle.abilitytree.guiskillscreen.MainSkillScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class KeyHandler
{
	public static KeyBinding[] keyBindings;

	static
	{
		keyBindings = new KeyBinding[2];
		keyBindings[0] = new KeyBinding("key.refill.desc",Keyboard.KEY_P,"key.examplemod.category");
		keyBindings[1] = new KeyBinding("key.info.desc",Keyboard.KEY_I,"key.examplemod.category");

		for(KeyBinding keyBinding : keyBindings)
			ClientRegistry.registerKeyBinding(keyBinding);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyPress(InputEvent.KeyInputEvent event)
	{
		EntityPlayer player = Minecraft.getMinecraft().player;
		if(keyBindings[0].isPressed())//P
		{
			FMLCommonHandler.instance().showGuiScreen(new advancedGuiScreen());
		}
		if(keyBindings[1].isPressed())//Call Main skill screen
		{
			FMLCommonHandler.instance().showGuiScreen(new MainSkillScreen());
		}
	}
}
