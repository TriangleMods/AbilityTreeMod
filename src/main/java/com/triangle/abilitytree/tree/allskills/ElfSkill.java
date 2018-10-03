package com.triangle.abilitytree.tree.allskills;

import com.triangle.abilitytree.events.UpdateDebugger;
import com.triangle.abilitytree.tree.Counter;
import com.triangle.abilitytree.tree.Reward;
import com.triangle.abilitytree.tree.Skill;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;

public class ElfSkill extends Skill
{

	public ElfSkill()
	{
		setName("Elf80");
		addCounter(new ElfCounter(20));
		addReward(new ElfReward());
		setCoord(100,100);
	}

	class ElfReward extends Reward
	{
		public ElfReward()
		{
			this.setDescription("Есть шанс, что вы не тратите стрелы");
			this.setEventType(ArrowLooseEvent.class);
		}

		@Override
		protected void influenceOnEvent(Event e) {
			ArrowLooseEvent event = (ArrowLooseEvent)e;

			int charge = event.getCharge();

			if(charge >= 3 && charge < 20)
			{
				charge = charge*charge/8 + 3;
				if(charge > 20)
					charge = 20;
				event.setCharge(charge);
			}
		}
	}

	class ElfCounter extends Counter
	{

		public ElfCounter(int maxValue) throws IndexOutOfBoundsException {
			super("shoot", maxValue, ArrowLooseEvent.class, "Выстрел с полным натяжением");
		}

		@Override
		protected void handle(Event e) {
			if( ((ArrowLooseEvent)e).getCharge() >= 20)
				super.handle(e);
		}
	}
}