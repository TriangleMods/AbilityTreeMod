package com.triangle.abilitytree.tree.allskills;

import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Skill;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class HarvestSkill2 extends Skill
{
	Counter boneCounter = new Counter("bonemeal",  7, BonemealEvent.class);
	Counter bucketCounter = new Counter("queen",  3, FillBucketEvent.class);

	public HarvestSkill2()
	{
		setName("HarvestSkill");
		addCounter(boneCounter);
		addCounter(bucketCounter);
		setCoord(100,100);
	}
}
