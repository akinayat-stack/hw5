package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    private static final double CRITICAL_MULTIPLIER = 1.5;

    @Override
    public String getActionName() {
        return super.getActionName() + " [Critical Focus]";
    }

    @Override
    public int getDamage() {
        return (int) (super.getDamage() * CRITICAL_MULTIPLIER);
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " + critical focus (x1.5 dmg)";
    }
}
