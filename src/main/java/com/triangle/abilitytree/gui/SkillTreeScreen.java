package com.triangle.abilitytree.gui;

import com.triangle.abilitytree.capabilities.SkillTreeExtractor;
import com.triangle.abilitytree.tree.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

import java.awt.*;
import java.io.IOException;

//DOC_ME
public class SkillTreeScreen extends GuiScreen {

	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/background_gui_skill_1.png");

	int guiWidth = 256;
	int guiHeight = 256;

	@Override
	public void initGui()
	{
		buttonList.clear();
		//get zero
		for (Skill skill : SkillTreeExtractor.getAllSkillTrees(Minecraft.getMinecraft().player).getSkillTrees().get(0).getAllSkills())
		{
			buttonList.add(new SkillButton(1, skill));
		}

		buttonList.add( new GuiButton(0, (width / 2) + 28, height/2 + 128, 100, 20, "Close"));

		super.initGui();

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id)
		{
			case 0:
				mc.displayGuiScreen(null);
				break;
			case 1:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("button is clicked"));
				break;
		}


	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{


		Point zeroCoord = new Point((width - guiWidth )/ 2, (height - guiHeight) / 2);


		Minecraft.getMinecraft().renderEngine.bindTexture(texture);



		drawTexturedModalRect(zeroCoord.x, zeroCoord.y, 0, 0, guiWidth, guiHeight);

		//================================

		System.out.println("---");
		System.out.println("Buttons: "+buttonList.size());

		for (GuiButton guiButton : buttonList)
		{
			System.out.println("{");
			if(guiButton instanceof SkillButton)
			{
				System.out.println("_");
				((SkillButton) guiButton).drawButton(mc, mouseX, mouseY, zeroCoord, partialTicks);
				System.out.println("1");
			}
			else
			{
				System.out.println("-");
				guiButton.drawButton(mc, mouseX, mouseY, partialTicks);
				System.out.println("0");
			}
			System.out.println("}");
		}

		//================================
		System.out.println("(3)");
		for (GuiButton guiButton : buttonList)
		{

				if(guiButton.isMouseOver() && guiButton instanceof SkillButton)
				{
					drawHoveringText(((SkillButton)guiButton).getTextStrings(), mouseX, mouseY);
				}
			System.out.println(".");
		}

		System.out.println("DRAWED SCREEN");
	}
}
