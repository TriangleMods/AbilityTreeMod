package com.triangle.abilitytree.guiexample;


import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class skillButton extends GuiButton
{

	final ResourceLocation texture = new ResourceLocation( "guiexperimetal:textures/gui/button.png");

	int buttonWidth = 37;
	int buttonHeight = 34;
	int u = 0;
	int v = 48;

	boolean cover = true;

	public final Skill skillDTO;

	public skillButton(int buttonId, int x, int y, Skill skill) {
		super(buttonId, x, y, 37, 34, "");
		this.skillDTO = skill;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{

		if (visible)
		{
			mc.renderEngine.bindTexture(texture);

			if(!cover)
			{
				hovered = true;
			}
			else
			{
				hovered = false;
			}
			/*
			if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height)
			{
				hovered = true;
			}
			else
			{
				hovered = false;
			}
			*/
			if(hovered)
			{
				u = 40;
			}
			else
			{
				u = 0;
			}

			drawTexturedModalRect(x, y, u, v, width, height);
		}

	}


	

}
