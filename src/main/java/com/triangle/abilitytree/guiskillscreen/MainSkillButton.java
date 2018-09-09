package com.triangle.abilitytree.guiskillscreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class MainSkillButton extends GuiButton
{

		final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/mainbuttons.png");

		int u;
		int v = 0;

		public MainSkillButton(int buttonId, int x, int y, int u)
		{
			super(buttonId, x, y, 51, 48, "");
			this.u=u;
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
					v = 56;
				}
				else
				{
					v = 0;
				}

				drawTexturedModalRect(x, y, u, v, width, height);
			}
		}

}
