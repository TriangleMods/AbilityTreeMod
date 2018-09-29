package com.triangle.abilitytree.guiskillscreen;

import com.triangle.abilitytree.guiskillscreen.skillguiscreens.CombatSkillScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.IOException;

public class MainSkillScreen extends GuiScreen
{
	MainButton combatMainButton;
	MainButton witcheryMainButton;
	MainButton adventureMainButton;
	MainButton workingMainButton;
	MainButton miningMainButton;

	//MainSkillButton amb;



	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(combatMainButton = new MainButton(1,width/2 - 25 - 102,height/2, MainButton.TextureOffset.COMBAT));
		buttonList.add(witcheryMainButton = new MainButton(2,width/2 - 25 - 51,height/2, MainButton.TextureOffset.WITCHERY));
		buttonList.add(adventureMainButton = new MainButton(3,width/2 - 25,height/2, MainButton.TextureOffset.ADVENTURE));
		buttonList.add(workingMainButton = new MainButton(4,width/2 + 26,height/2, MainButton.TextureOffset.WORKING));
		buttonList.add(miningMainButton = new MainButton(5,width/2 + 26 + 51,height/2, MainButton.TextureOffset.MINING));
		//buttonList.add(amb = new MainSkillButton(3,width/2 + 26, height/2,102));

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch (button.id)
		{
			case 1:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("combat button is clicked"));
				break;
			case 2:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("witchery button is clicked"));
				break;
			case 3:
				FMLCommonHandler.instance().showGuiScreen(new CombatSkillScreen());
				break;
			case 4:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("working button is clicked"));
				break;
			case 5:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("mining button is clicked"));
				break;
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}


}
