package com.triangle.abilitytree.guiexample;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.opengl.GL11;

public class basicButton extends GuiButton
{
	private static ResourceLocation guiTexture;


	public basicButton(int screenWidth)
	{
		super(1, screenWidth/2-100,20,200,20,"Hello bitch");
	}




}
