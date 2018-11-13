package com.triangle.abilitytree.gui.toasts;

import com.triangle.abilitytree.tree.Skill;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.gui.toasts.IToast;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SkillCompletedToast implements IToast
{
	private Skill skill;
	private Visibility visibility = Visibility.SHOW;

	public SkillCompletedToast(Skill skill)
	{
		this.skill = skill;
	}


	//TODO повторяющийся код
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
		toastGui.getMinecraft().fontRenderer.drawString("Completed!", 30, 17, -11534256);

		return delta >= 2000L ? Visibility.HIDE : Visibility.SHOW;
	}



}
