package com.elvarg.world.entity.combat.method.impl.specials;

import com.elvarg.world.entity.combat.CombatSpecial;
import com.elvarg.world.entity.combat.CombatType;
import com.elvarg.world.entity.combat.hit.PendingHit;
import com.elvarg.world.entity.combat.method.CombatMethod;
import com.elvarg.world.entity.impl.Character;
import com.elvarg.world.model.Animation;
import com.elvarg.world.model.Graphic;
import com.elvarg.world.model.GraphicHeight;
import com.elvarg.world.model.Priority;

public class DragonHalberdCombatMethod implements CombatMethod {

	private static final Animation ANIMATION = new Animation(1203, Priority.HIGH);
	private static final Graphic GRAPHIC = new Graphic(282, GraphicHeight.HIGH, Priority.HIGH);
	
	@Override
	public CombatType getCombatType() {
		return CombatType.MELEE;
	}

	@Override
	public PendingHit[] getHits(Character character, Character target) {
		return new PendingHit[]{new PendingHit(character, target, this, true, 1), new PendingHit(character, target, this, true, 0)};
	}

	@Override
	public boolean canAttack(Character character, Character target) {
		return true;
	}

	@Override
	public void preQueueAdd(Character character, Character target) {
		CombatSpecial.drain(character, CombatSpecial.DRAGON_HALBERD.getDrainAmount());
	}

	@Override
	public int getAttackSpeed(Character character) {
		return character.getBaseAttackSpeed();
	}

	@Override
	public int getAttackDistance(Character character) {
		return 2;
	}

	@Override
	public void startAnimation(Character character) {
		character.performAnimation(ANIMATION);
		character.performGraphic(GRAPHIC);
	}

	@Override
	public void finished(Character character) {

	}

	@Override
	public void handleAfterHitEffects(PendingHit hit) {
	}
}