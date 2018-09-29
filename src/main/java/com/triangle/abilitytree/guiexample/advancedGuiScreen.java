package com.triangle.abilitytree.guiexample;


import com.triangle.abilitytree.tree.capabilities.CapabilityExtractor;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextComponentString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class advancedGuiScreen extends GuiScreen
{

	skillButton skillB;

	final int SKILLB = 3;


	@Override
	public void initGui()
	{
		Skill someSkill =  CapabilityExtractor.getSkillTree(Minecraft.getMinecraft().player).getRootSkill().getChildSkills().get(0);

		buttonList.clear();
		buttonList.add(skillB = new skillButton(SKILLB,width/2, height/2,someSkill));

		super.initGui();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch (button.id)
		{
			case 1:
				break;
			case 3:
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

		skillB.drawButton(mc, mouseX, mouseY, partialTicks);

		if(mouseX >= centerX && mouseX <= centerX + 40 && mouseY >= centerY && mouseY <= centerY + 40)
		{
			List<String> text = new ArrayList<String>();
			text.add(skillB.skillDTO.getName());
			text.add("Jump: " + skillB.skillDTO.getCounters().get(0).getValue());
			drawHoveringText(text, mouseX, mouseY);
		}



	}
}
