package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class HarvestSkill2 extends Skill
{
	Counter boneCounter = new Counter("bonemeal",  7);
	Counter bucketCounter = new Counter("queen",  3);

	public HarvestSkill2()
	{
		setName("ChildSkill");
		addCounter(boneCounter);
		addCounter(bucketCounter);
	}

	@Override
	protected void handleEvent(Event e)
	{
		super.handleEvent(e);
		if(e instanceof BonemealEvent)
		{
			boneCounter.add(1);
		}
		else if(e instanceof FillBucketEvent)
		{
			bucketCounter.add(1);
		}

	}

	@Override
	public String getName()
	{
		return "c1";
	}
}
