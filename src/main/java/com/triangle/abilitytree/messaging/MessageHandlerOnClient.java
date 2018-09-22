package com.triangle.abilitytree.messaging;

import com.triangle.abilitytree.tree.capabilities.ISkillTree;
import com.triangle.abilitytree.tree.capabilities.SkillTreeProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageHandlerOnClient implements IMessageHandler<TreeDataMessageToClient, IMessage>
{
	@Override
	public IMessage onMessage(TreeDataMessageToClient message, MessageContext context)
	{
		if (context.side != Side.CLIENT) {
			System.err.println("TargetEffectMessageToClient received on wrong side:" + context.side);
			return null;
		}
		Minecraft minecraft = Minecraft.getMinecraft();

		final WorldClient worldClient = minecraft.world;
		minecraft.addScheduledTask(new Runnable()
		{
			public void run() {

				processMessage(message);
			}
		});

		return null;
	}

	void processMessage(TreeDataMessageToClient message)
	{
		EntityPlayer player = Minecraft.getMinecraft().player;
		ISkillTree skillTree = player.getCapability(SkillTreeProvider.SKILL_TREE_CAPABILITY, null);
		skillTree.setDataFromString(message.getData());
	}
}
