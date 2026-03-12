package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    private static void printAction(AttackAction action) {
        System.out.printf("  %-55s | dmg: %3d | %s%n",
                action.getActionName(), action.getDamage(), action.getEffectSummary());
    }

    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Aric the Bold", 120);
        BossEnemy boss = new BossEnemy("Shadow Drake", 150, 18);

        AttackAction basic = new BasicAttack("Sword Strike", 12);
        AttackAction fireOnly = new FireRuneDecorator(basic);
        AttackAction poisonOnly = new PoisonCoatingDecorator(basic);
        AttackAction critOnly = new CriticalFocusDecorator(basic);
        AttackAction fullEnhanced = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)
                )
        );

        System.out.println("--- Decorator Combinations ---");
        printAction(basic);
        printAction(fireOnly);
        printAction(poisonOnly);
        printAction(critOnly);
        printAction(fullEnhanced);

        System.out.println("\n--- Decorator Order Effect ---");
        AttackAction critFirst = new CriticalFocusDecorator(new FireRuneDecorator(basic));
        AttackAction fireFirst = new FireRuneDecorator(new CriticalFocusDecorator(basic));
        System.out.println("Crit(Fire(base)) dmg: " + critFirst.getDamage()
                + "  -> " + critFirst.getActionName());
        System.out.println("Fire(Crit(base)) dmg: " + fireFirst.getDamage()
                + "  -> " + fireFirst.getActionName());

        System.out.println("\n--- Facade: Full Dungeon Run ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, fullEnhanced);

        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println();
        System.out.println("Winner : " + result.getWinner());
        System.out.println("Rounds : " + result.getRounds());
        System.out.println("Reward : " + result.getReward());

        System.out.println("\n=== Demo Complete ===");
    }
}
