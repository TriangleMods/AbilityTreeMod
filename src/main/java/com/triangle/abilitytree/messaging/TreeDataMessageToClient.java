package com.triangle.abilitytree.messaging;

import com.triangle.abilitytree.capabilities.ISkillTree;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.nio.charset.StandardCharsets;

//DOC_ME
public class TreeDataMessageToClient implements IMessage
{
	public TreeDataMessageToClient(){}

	private String dataString;

	public String getData()
	{
		return dataString;
	}

	public TreeDataMessageToClient(ISkillTree tree) {
		this.dataString = tree.getDataAsString();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBytes(dataString.getBytes());
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		dataString = buf.toString(0,buf.readableBytes(), StandardCharsets.UTF_8);
	}
}
