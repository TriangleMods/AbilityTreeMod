package com.triangle.abilitytree.gui;

import com.triangle.abilitytree.tree.Skill;
import com.triangle.abilitytree.tree.SkillTree;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

//DOC_ME
public class TabGuiButton extends GuiButton
{
	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/tabbutton.png");

	public final int skillTreeId;

	public TabGuiButton(int buttonId, int skillTreeId, int x, int y)
	{
		super(buttonId, x, y,30,30 ,"");
		this.skillTreeId = skillTreeId;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;

		mc.renderEngine.bindTexture(texture);

		drawTexturedModalRect(x,y,0,0,30,30);
	}
}
