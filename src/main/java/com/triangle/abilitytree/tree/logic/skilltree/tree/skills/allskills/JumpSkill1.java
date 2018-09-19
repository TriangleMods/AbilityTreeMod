package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class JumpSkill1 extends Skill
{
	public JumpSkill1()
	{
		addCounter(new Counter("jump", 5));
		addChild(new HarvestSkill2());
		setName("Jumper");
	}

	@Override
	protected void handleEvent(Event e)
	{
		super.handleEvent(e);
		if(e instanceof LivingEvent.LivingJumpEvent)
		{
			this.getCounters().get(0).add(1);
		}
	}

	@Override
	public String getName()
	{
		return "f1";
	}


}
