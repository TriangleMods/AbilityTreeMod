package com.triangle.abilitytree.gui;

import com.triangle.abilitytree.capabilities.SkillTreeExtractor;
import com.triangle.abilitytree.tree.Skill;
import com.triangle.abilitytree.tree.SkillTree;
import javafx.scene.control.ButtonType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import scala.xml.Null;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

//Contains tabs with skillTrees
public class SkillTreeScreen extends GuiScreen
{
	ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/background_gui_skill_1.png");

	int guiWidth = 256;
	int guiHeight = 256;

	int activeTab = 0;

	//Default minecraft buttons
	private ArrayList<GuiButton> allGuiButtons = new ArrayList<>();

	//Left tab buttons
	private ArrayList<TabGuiButton> tabButtonList = new ArrayList<>();

	//Currently displayed skill buttons
	private ArrayList<SkillButton> skillButtonList = new ArrayList<>();

	void updateSkillList()
	{
		SkillTree displayingSkillTree = SkillTreeExtractor.getAllSkillTrees(Minecraft.getMinecraft().player).getSkillTrees().get(activeTab);

		skillButtonList.clear();

		for (Skill skill : displayingSkillTree.getAllSkills())
		{
			skillButtonList.add(new SkillButton(ButtonType.SKILL.getValue(), skill));
		}
	}

	@Override
	public void initGui()
	{
		System.out.println("init gui");

		buttonList.clear();
		tabButtonList.clear();
		updateSkillList();

		//adding tabs buttons
		for (int i = 0; i < SkillTreeExtractor.getAllSkillTrees(Minecraft.getMinecraft().player).getSkillTrees().size(); ++i)
		{
			tabButtonList.add(new TabGuiButton(ButtonType.TAB.getValue(), i, (width - guiWidth )/ 2 - 30,(height - guiHeight) / 2 + i * 45));
		}

		//adding exit button
		buttonList.add( new GuiButton(ButtonType.GUI.getValue(), (width / 2) + 28, height/2 + 128, 100, 20, "Close"));

		super.initGui();

	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		//left click
		if (mouseButton == 0)
		{
			allGuiButtons.clear();
			allGuiButtons.addAll(buttonList);
			allGuiButtons.addAll(tabButtonList);
			allGuiButtons.addAll(skillButtonList);

			for (int i = 0; i < this.allGuiButtons.size(); ++i)
			{
				GuiButton guibutton = this.allGuiButtons.get(i);

				if (guibutton.mousePressed(this.mc, mouseX, mouseY))
				{
					net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Pre event = new net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Pre(this, guibutton, this.buttonList);
					if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
						break;
					guibutton = event.getButton();
					this.selectedButton = guibutton;
					guibutton.playPressSound(this.mc.getSoundHandler());
					this.actionPerformed(guibutton);
					if (this.equals(this.mc.currentScreen))
						net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent.Post(this, event.getButton(), this.buttonList));
				}
			}
		}
	}

	//Click handler
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		switch (ButtonType.fromInt(button.id))
		{
			case GUI:
				mc.displayGuiScreen(null);
				break;
			case SKILL:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("button is clicked"));
				break;
			case TAB:
				activeTab = ((TabGuiButton)button).skillTreeId;
				updateSkillList();
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString(activeTab + ""));
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

		//three loops due different drawing params of SkillButtons

		for (TabGuiButton button : tabButtonList)
		{
			button.drawButton(this.mc, mouseX, mouseY, partialTicks);
		}

		for (SkillButton button : skillButtonList)
		{
			button.drawButton(this.mc, mouseX, mouseY,zeroCoord ,partialTicks);
		}

		for (GuiButton button : buttonList)
		{
				button.drawButton(mc, mouseX, mouseY, partialTicks);
		}

		for (SkillButton guiButton : skillButtonList)
		{
				if(guiButton.isMouseOver())
				{
					drawHoveringText(guiButton.getTextStrings(), mouseX, mouseY);
				}
		}

		for (TabGuiButton tabButton : tabButtonList)
		{
			if(tabButton.isMouseOver())
			{
				drawHoveringText(SkillTreeExtractor.getAllSkillTrees(Minecraft.getMinecraft().player).getSkillTrees().get(tabButton.skillTreeId).getSkillTreeData().getTreeName(), mouseX, mouseY);
			}
		}
	}

	public enum ButtonType
	{
		TAB(0),
		SKILL(1),
		GUI(2);

		private final int value;

		public static ButtonType fromInt(int i)
		{
			switch (i)
			{
				case 0: return TAB;
				case 1: return SKILL;
				case 2: return GUI;
				default: return null;
			}
		}

		private ButtonType(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}
	}
}

