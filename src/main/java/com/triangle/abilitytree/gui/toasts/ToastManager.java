package com.triangle.abilitytree.gui.toasts;

import com.triangle.abilitytree.events.UpdateDebugger;
import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Skill;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;

public class ToastManager
{
	private static ArrayList<SkillProgressToast> toastOnDisplay = new ArrayList<>();

	public static void showSkillProgressToast(Skill skill, Counter counter)
	{
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			Boolean isToastOnDisplay = false;
			SkillProgressToast toast = null;
			for (SkillProgressToast skillProgressToast : toastOnDisplay)
			{
				if (skillProgressToast.getCounter().equals(counter))
				{
					isToastOnDisplay = true;
					toast = skillProgressToast;
					break;
				}
			}

			if(isToastOnDisplay)
			{
				toast.enlargeDelay();
			}
			else
			{
				toast = new SkillProgressToast(skill, counter);
				Minecraft.getMinecraft().getToastGui().add(toast);
				toastOnDisplay.add(toast);
			}

		}
	}

	public static void removeSkillProgressToast(SkillProgressToast toast)
	{
		toastOnDisplay.remove(toast);
	}

	public static void showSkillCompletedToast(Skill skill)
	{
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
			Minecraft.getMinecraft().getToastGui().add(new SkillCompletedToast(skill));
	}
}
