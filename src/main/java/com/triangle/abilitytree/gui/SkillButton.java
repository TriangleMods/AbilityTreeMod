package com.triangle.abilitytree.gui;

import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Reward;
import com.triangle.abilitytree.tree.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//DOC_ME
public class SkillButton extends GuiButton
{
	ResourceLocation texture;

	public final Skill skill;

	public SkillButton(int buttonId, Skill skill, String modName, String treeName)
	{
		super(buttonId,skill.getCoord().x, skill.getCoord().y,20,20,"");
		this.skill = skill;
		texture = new ResourceLocation(modName +":textures/gui/"+treeName+"/buttons.png");
	}


	public void drawButton(Minecraft mc, int mouseX, int mouseY, Point zeroCoord, float partialTicks)
	{
		this.x = zeroCoord.x + skill.getCoord().x;
		this.y = zeroCoord.y + skill.getCoord().y;

		this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;

		mc.renderEngine.bindTexture(texture);

		drawTexturedModalRect(x, y, skill.getTextureCoord().x*width, skill.getTextureCoord().y*height, width, height);
	}

	public List<String> getTextStrings()
	{
		List<String> text = new ArrayList<>();
		text.add(skill.getName());
		for (Counter counter : skill.getCounters())
		{
			text.add(counter.getDescription());
			text.add(counter.getName() +": "+ counter.getValue() +"/" + counter.getMaxValue());
		}

		for (Reward reward : skill.getRewards())
		{
			text.add(reward.getDescription());
		}
		return text;
	}
}
