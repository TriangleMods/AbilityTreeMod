package com.triangle.abilitytree.guiskillscreen.mainskillbuttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class WitcheryMainButton extends GuiButton
{
	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/mainbuttons.png");

	int u = 51;
	int v = 0;

	public WitcheryMainButton(int buttonId, int x, int y)
	{
		super(buttonId, x, y, 50, 50, "");
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		if(visible)
		{
			mc.renderEngine.bindTexture(texture);

			if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height)
			{
				hovered = true;
			}
			else
			{
				hovered = false;
			}
			if(hovered)
			{
				v = 58;
			}
			else
			{
				v = 0;
			}

			drawTexturedModalRect(x, y, u, v, width, height);
		}
	}
}
