package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            throw new IllegalArgumentException("Hero, boss, and action must not be null");
        }
        return String.format("Preparation complete: %s (HP:%d) vs %s (HP:%d) using [%s] (dmg:%d)",
                hero.getName(), hero.getHealth(),
                boss.getName(), boss.getHealth(),
                action.getActionName(), action.getDamage());
    }
}
