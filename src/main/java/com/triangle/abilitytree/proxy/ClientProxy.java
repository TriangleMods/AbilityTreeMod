package com.triangle.abilitytree.proxy;


import com.triangle.abilitytree.keys.KeyHandler;
import com.triangle.abilitytree.messaging.MessageHandlerOnClient;
import com.triangle.abilitytree.messaging.TreeDataMessageToClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;

//DOC_ME
public class ClientProxy extends CommonProxy
{


	public void preInit()
	{
		super.preInit();

	}


	public void init()
	{
		super.init();
		MinecraftForge.EVENT_BUS.register(new KeyHandler());

		CommonProxy.simpleNetworkWrapper.registerMessage(MessageHandlerOnClient.class, TreeDataMessageToClient.class,
				CommonProxy.TREE_DATA_MESSAGE_ID, Side.CLIENT);
	}


	public void postInit()
	{
		super.postInit();
	}
}
