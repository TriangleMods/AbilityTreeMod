package com.triangle.abilitytree.guiskillscreen.skillbuttons;

import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class SimpleFirstButton extends GuiButton
{
	int u = 0;
	int v = 0;

	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/button.png");

	public final Skill skill;

	public SimpleFirstButton(int buttonId, int x, int y, Skill skill)
	{
		super(buttonId,x,y,20,20,"");
		this.skill = skill;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		mc.renderEngine.bindTexture(texture);

		drawTexturedModalRect(x, y, u, v, width, height);
	}
}
