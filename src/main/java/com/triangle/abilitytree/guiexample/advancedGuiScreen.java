package com.triangle.abilitytree.guiexample;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.client.config.GuiButtonExt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class advancedGuiScreen extends GuiScreen
{

	skillButton skillB;

	final int SKILLB = 1;


	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(skillB = new skillButton(SKILLB,width/2, height/2));
		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch (button.id)
		{
			case 1:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("button is clicked"));
				break;
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		drawDefaultBackground();

		int centerX = (width / 2);
		int centerY = (height / 2);

		super.drawScreen(mouseX, mouseY, partialTicks);

		if(mouseX >= centerX && mouseX <= centerX + 40 && mouseY >= centerY && mouseY <= centerY + 40)
		{
			List<String> text = new ArrayList<String>();
			text.add("Hello");
			drawHoveringText(text, mouseX, mouseY);
		}



	}
}
