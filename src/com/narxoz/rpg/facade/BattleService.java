package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    private static final int MAX_ROUNDS = 20;

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int round = 0;

        while (hero.isAlive() && boss.isAlive() && round < MAX_ROUNDS) {
            round++;

            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);
            result.addLine(String.format("Round %d: %s attacks %s for %d dmg (effects: %s) — %s HP: %d",
                    round, hero.getName(), boss.getName(), heroDamage,
                    action.getEffectSummary(), boss.getName(), boss.getHealth()));

            if (!boss.isAlive()) {
                break;
            }

            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(String.format("Round %d: %s retaliates for %d dmg — %s HP: %d",
                    round, boss.getName(), bossDamage, hero.getName(), hero.getHealth()));
        }

        result.setRounds(round);

        if (hero.isAlive() && !boss.isAlive()) {
            result.setWinner(hero.getName());
        } else if (!hero.isAlive() && boss.isAlive()) {
            result.setWinner(boss.getName());
        } else {
            result.setWinner("Draw");
        }

        if (random.nextInt(1) == 0) {
            // deterministic seed consumed to keep seed-based reproducibility
        }

        return result;
    }
}
