package com.triangle.abilitytree.messaging;

import com.triangle.abilitytree.capabilities.SkillTreeExtractor;
import com.triangle.abilitytree.capabilities.ISkillTreeList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

//Updates player SkillTree capability with new data from server
//(Some event raise only on server-side, so we need sync)
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
		ISkillTreeList skillTree = SkillTreeExtractor.getAllSkillTrees(player);
		skillTree.setDataFromString(message.getData());
	}
}
