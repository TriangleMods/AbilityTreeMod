package com.triangle.abilitytree.guiskillscreen.skillguiscreens;

import com.triangle.abilitytree.guiskillscreen.skillbuttons.SkillButton;
import com.triangle.abilitytree.tree.capabilities.CapabilityExtractor;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkillTreeScreen extends GuiScreen {

	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/background_gui_skill_1.png");

	GuiButton CloseButton;
	SkillButton firstButton;
	SkillButton secondButton;

	@Override
	public void initGui() {
		buttonList.clear();

		//TODO Скиллы нужно не хардкодить, а считывать алгоритмом
		Skill rootSkill = CapabilityExtractor.getSkillTree(Minecraft.getMinecraft().player).getRootSkill();
		Skill childSkill = rootSkill.getChildSkills().get(0);
		Skill grandChildSkill = childSkill.getChildSkills().get(0);

		buttonList.add(firstButton = new SkillButton(1, (width / 2) - 10, (height / 2) - 10, childSkill));
		buttonList.add(secondButton = new SkillButton(1, (width / 2) - 67, (height / 2) - 57, grandChildSkill));

		buttonList.add(CloseButton = new GuiButton(0, (width / 2) + 28, height/2 + 128, 100, 20, "Close"));

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
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		int centerX = (width / 2);
		int centerY = (height / 2);


		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		drawTexturedModalRect(width / 2 - 128, height / 2 - 128, 0, 0, 256, 256);


		firstButton.drawButton(mc, mouseX, mouseY, partialTicks);
		secondButton.drawButton(mc, mouseX, mouseY, partialTicks);

		//центральная кнопка
		//найти альтернативу отображения потому что так не хочет работать ибо координаты не воспринимает от центра

		//TODO Проходишься по списку кнопок, для каждой проверяешь isMouseOnButton(mouseX, mouseY)
		//Если находится на кнопке
			//TODO drawHoveringText(твоя кнопка.getTextStrings(), mouseX, mouseY);

		if (mouseX >= centerX && mouseX <= centerX + 20 && mouseY >= centerY && mouseY <= centerY + 10) {
			{
				List<String> text = new ArrayList<String>();
				text.add(firstButton.skill.getName());
				text.add("Jump: " + firstButton.skill.getCounters().get(0).getValue());
				drawHoveringText(text, mouseX, mouseY);
			}

		}

		CloseButton.drawButton(mc, mouseX, mouseY, partialTicks);
	}
}
