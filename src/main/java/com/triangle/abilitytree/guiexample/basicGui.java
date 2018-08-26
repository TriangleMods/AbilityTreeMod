package com.triangle.abilitytree.guiexample;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class basicGui extends GuiScreen
{

    private final int guiHeight = 192;
    private final int guiWidth = 256;
    private static ResourceLocation guiTexture;

    public basicGui()
    {
        guiTexture = new ResourceLocation("guiexperimetal:textures/gui/basic_gui.png");
    }

    private String formatString(String s)
    {
        return s.replaceAll("NL", "\n\n");
    }

    @Override
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);

    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
    }

    @Override
    public void drawScreen(int w, int h, float p_73863_3_)
    {
        GL11.glColor4f(1.0F,1.0F,1.0F,1.0F);
        mc.getTextureManager().bindTexture(guiTexture);
        int offsetFromScreenLeft = (width - guiWidth) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2,0,0,guiWidth,guiHeight);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked( mouseX,mouseY,mouseButton);
    }

    @Override
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }



}