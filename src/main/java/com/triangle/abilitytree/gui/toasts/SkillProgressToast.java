package com.triangle.abilitytree.gui.toasts;

import com.triangle.abilitytree.events.UpdateDebugger;
import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Skill;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SkillProgressToast implements IToast
{
	private final Skill skill;
	private final Counter counter;

	private IToast.Visibility visibility = IToast.Visibility.SHOW;

	private long delay = 2000L;


	public void enlargeDelay()
	{
		delay += 1000;
	}

	public SkillProgressToast(Skill skill, Counter counter)
	{
		this.skill = skill;
		this.counter = counter;
	}

	public Counter getCounter()
	{
		return counter;
	}

	@Override
	public Visibility draw(GuiToast toastGui, long delta)
	{
		toastGui.getMinecraft().getTextureManager().bindTexture(TEXTURE_TOASTS);
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		toastGui.drawTexturedModalRect(0, 0, 0, 96, 160, 32);

		GlStateManager.enableBlend();
		toastGui.getMinecraft().getTextureManager().bindTexture(skill.getTexture());
		toastGui.drawTexturedModalRect(6, 6, skill.getTextureCoord().x*20, skill.getTextureCoord().y*20, 20, 20);
		GlStateManager.enableBlend();

		toastGui.getMinecraft().fontRenderer.drawString(this.skill.getName(), 30, 7, -11534256);
		toastGui.getMinecraft().fontRenderer.drawString(this.counter.toString(), 30, 17, -11534256);

		if(delta >= delay)
		{
			ToastManager.removeSkillProgressToast(this);
			return IToast.Visibility.HIDE;
		}
		else
			return IToast.Visibility.SHOW;

	}



}
