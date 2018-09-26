package com.triangle.abilitytree.guiskillscreen;

import com.triangle.abilitytree.guiskillscreen.mainskillbuttons.*;
import com.triangle.abilitytree.guiskillscreen.skillguiscreens.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.io.IOException;

public class MainSkillScreen extends GuiScreen
{
	GuiButton CloseButton;
	CombatMainButton combatMainButton;
	WitcheryMainButton witcheryMainButton;
	AdventureMainButton adventureMainButton;
	WorkingMainButton workingMainButton;
	MiningMainButton miningMainButton;
	


	@Override
	public void initGui()
	{
		buttonList.clear();

		buttonList.add(combatMainButton = new CombatMainButton(1,width/2 - 25 - 100,height/2));
		buttonList.add(witcheryMainButton = new WitcheryMainButton(2,width/2 - 25 - 50,height/2));
		buttonList.add(adventureMainButton = new AdventureMainButton(3,width/2 - 25,height/2));
		buttonList.add(workingMainButton = new WorkingMainButton(4,width/2 + 25,height/2));
		buttonList.add(miningMainButton = new MiningMainButton(5,width/2 + 25 + 50,height/2));

		buttonList.add(CloseButton = new GuiButton(0, (width / 2) + 25, (height / 2) - 25, 100, 20, "Close"));

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch (button.id)
		{
			case 0:
				mc.displayGuiScreen(null);
				break;
			case 1:
				FMLCommonHandler.instance().showGuiScreen(new CombatSkillScreen());
				break;
			case 2:
				FMLCommonHandler.instance().showGuiScreen(new WitcherySkillScreen());
				break;
			case 3:
				FMLCommonHandler.instance().showGuiScreen(new AdventureSkillScreen());
				break;
			case 4:
				FMLCommonHandler.instance().showGuiScreen(new WorkingSkillScreen());
				break;
			case 5:
				FMLCommonHandler.instance().showGuiScreen(new MiningSkillScreen());
				break;
		}
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}


}
