package com.triangle.abilitytree.guiskillscreen.skillbuttons;

import com.triangle.abilitytree.dto.ISkillDTO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class SimpleFirstButton extends GuiButton
{
	int u = 0;
	int v = 0;

	final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/buttons.png");

	public final ISkillDTO skillDTO;

	public SimpleFirstButton(int buttonId, int x, int y, ISkillDTO skillDTO)
	{
		super(buttonId,x,y,10,10,"");
		this.skillDTO = skillDTO;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		mc.renderEngine.bindTexture(texture);

		drawTexturedModalRect(x, y, u, v, width, height);
	}
}
