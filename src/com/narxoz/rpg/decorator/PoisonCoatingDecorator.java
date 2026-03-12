package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    private static final int POISON_BONUS_DAMAGE = 5;

    @Override
    public String getActionName() {
        return super.getActionName() + " [Poison]";
    }

    @Override
    public int getDamage() {
        return super.getDamage() + POISON_BONUS_DAMAGE;
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " + poison coating (+5 poison dmg)";
    }
}
