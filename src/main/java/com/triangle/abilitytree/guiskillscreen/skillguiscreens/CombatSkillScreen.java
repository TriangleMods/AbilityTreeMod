package com.triangle.abilitytree.guiskillscreen.skillguiscreens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class CombatSkillScreen extends GuiScreen
{

	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/background_gui_skill.png");


	@Override
	public void initGui()
	{

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{

	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		drawTexturedModalRect(width/2 - 128, height/2 - 128, 0,0,256,256);

	}
}
