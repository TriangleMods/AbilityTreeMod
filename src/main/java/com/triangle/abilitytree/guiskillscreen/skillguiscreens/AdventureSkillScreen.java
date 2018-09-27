package com.triangle.abilitytree.guiskillscreen.skillguiscreens;

import com.triangle.abilitytree.dto.StaticField;
import com.triangle.abilitytree.guiskillscreen.MainSkillScreen;
import com.triangle.abilitytree.guiskillscreen.skillbuttons.SimpleFirstButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventureSkillScreen extends GuiScreen {

	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/background_gui_skill_1.png");

	GuiButton CloseButton;
	SimpleFirstButton firstButton;
	SimpleFirstButton secondButton;

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(firstButton = new SimpleFirstButton(1, (width / 2) - 10, (height / 2) - 10, StaticField.getSkill()));
		buttonList.add(secondButton = new SimpleFirstButton(1, (width / 2) - 67, (height / 2) - 57, StaticField.getSkill()));

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
		if (mouseX >= centerX && mouseX <= centerX + 20 && mouseY >= centerY && mouseY <= centerY + 10) {
			{
				List<String> text = new ArrayList<String>();
				text.add(firstButton.skillDTO.getName());
				text.add("Jump: " + firstButton.skillDTO.getCounters()[0].getValue());
				drawHoveringText(text, mouseX, mouseY);
			}

		}

		CloseButton.drawButton(mc, mouseX, mouseY, partialTicks);
	}
}
