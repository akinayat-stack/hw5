package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    private static final int FIRE_BONUS_DAMAGE = 8;

    @Override
    public String getActionName() {
        return super.getActionName() + " [Fire Rune]";
    }

    @Override
    public int getDamage() {
        return super.getDamage() + FIRE_BONUS_DAMAGE;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " + fire rune (+8 fire dmg)";
    }
}
