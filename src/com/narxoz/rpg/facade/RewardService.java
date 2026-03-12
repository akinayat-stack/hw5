package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward — invalid battle result";
        }
        String winner = battleResult.getWinner();
        if (winner == null || winner.equals("Draw")) {
            return "Consolation prize: 50 gold";
        }
        int rounds = battleResult.getRounds();
        if (rounds <= 3) {
            return "Perfect victory! Legendary chest: 500 gold + rare weapon";
        } else if (rounds <= 7) {
            return "Swift victory! Epic chest: 300 gold + uncommon armor";
        } else {
            return "Hard-fought victory: 150 gold + health potion";
        }
    }
}
