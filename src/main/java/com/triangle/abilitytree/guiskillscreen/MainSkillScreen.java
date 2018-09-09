package com.triangle.abilitytree.guiskillscreen;

import com.triangle.abilitytree.guiskillscreen.mainskillbuttons.*;
import com.triangle.abilitytree.guiskillscreen.skillguiscreens.CombatSkillScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.IOException;

public class MainSkillScreen extends GuiScreen
{
	CombatMainButton combatMainButton;
	WitcheryMainButton witcheryMainButton;
	AdventureMainButton adventureMainButton;
	WorkingMainButton workingMainButton;
	MiningMainButton miningMainButton;
	//MainSkillButton amb;


	@Override
	public void initGui()
	{
		buttonList.clear();
		buttonList.add(combatMainButton = new CombatMainButton(1,width/2 - 25 - 102,height/2));
		buttonList.add(witcheryMainButton = new WitcheryMainButton(2,width/2 - 25 - 51,height/2));
		buttonList.add(adventureMainButton = new AdventureMainButton(3,width/2 - 25,height/2));
		buttonList.add(workingMainButton = new WorkingMainButton(4,width/2 + 26,height/2));
		buttonList.add(miningMainButton = new MiningMainButton(5,width/2 + 26 + 51,height/2));
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
