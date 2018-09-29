package com.triangle.abilitytree.guiskillscreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class MainButton extends GuiButton
{
    final ResourceLocation texture = new ResourceLocation("guiexperimetal:textures/gui/mainbuttons.png");

    private final int u;
    private int v = 0;



    public MainButton(int buttonId, int x, int y, TextureOffset texture)
    {
        super(buttonId, x, y, 51, 48, "");

        u = width * texture.val;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if(visible)
        {
            mc.renderEngine.bindTexture(texture);

            if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height)
            {
                hovered = true;
            }
            else
            {
                hovered = false;
            }
            if(hovered)
            {
                v = 56;
            }
            else
            {
                v = 0;
            }

            drawTexturedModalRect(x, y, u, v, width, height);
        }
    }

    public enum TextureOffset
    {
        COMBAT(0),
        WITCHERY(1),
        ADVENTURE(2),
        WORKING(3),
        MINING(4);

        private final int val;
        private TextureOffset(int i)
        {
            val = i;
        }
    }
}
