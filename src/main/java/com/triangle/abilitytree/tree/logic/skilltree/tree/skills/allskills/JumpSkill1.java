package com.triangle.abilitytree.tree.logic.skilltree.tree.skills.allskills;

import com.triangle.abilitytree.tree.logic.skilltree.Counter;
import com.triangle.abilitytree.tree.logic.skilltree.tree.skills.Skill;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class JumpSkill1 extends Skill
{
	public JumpSkill1()
	{
		addCounter(new Counter("jump", 5, LivingEvent.LivingJumpEvent.class));
		addChild(new HarvestSkill2());
		setName("Jumper");
	}

}
