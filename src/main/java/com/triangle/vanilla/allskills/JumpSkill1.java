package com.triangle.vanilla.allskills;

import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Reward;
import com.triangle.abilitytree.tree.Skill;
import com.triangle.abilitytree.tree.SkillTreeData;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class JumpSkill1 extends Skill
{
	public JumpSkill1(SkillTreeData skillTreeData)
	{
		super(skillTreeData);
		addCounter(new Counter("jump", 5, LivingEvent.LivingJumpEvent.class, "Нужно много прыгать"));
		addChild(new ElfSkill(skillTreeData));
		setName("Jumper");
		setCoord(157,101);
		setTextureCoord(1,0);
		addReward(new HighJumpReward());
	}

	class HighJumpReward extends Reward
	{
		public HighJumpReward()
		{
			super("highjump");
			setDescription("Увеличивает высоту прыжка до двух блоков");
			setEventType(LivingEvent.LivingJumpEvent.class);
		}

		@Override
		protected void influenceOnEvent(Event e) {
			( (LivingEvent.LivingJumpEvent) e) .getEntity().motionY+=0.132;
		}
	}

}
