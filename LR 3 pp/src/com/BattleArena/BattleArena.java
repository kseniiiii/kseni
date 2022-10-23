package com.BattleArena;
import  com.Droid.Droid;

import java.util.Random;

public class BattleArena {
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public BattleArena(Droid firstDroid, Droid secondDroid) {
        if (new Random().nextBoolean()) {
            attacker = firstDroid;
            defender = secondDroid;
        }
        else {
            attacker = secondDroid;
            defender = firstDroid;
        }
    }

    public void fight() {
        do {
            swapOpponents();
            nextRound();
        } while (defender.isAlive());

        attacker.setHealth(attacker.getHealthBeforeFight());
        defender.setHealth(defender.getHealthBeforeFight());

        printWinnerInfo();
    }

    private void nextRound() {
        ++currentRound;
        int damage = attacker.getDamage();
        defender.getHit(damage);
        printRoundInfo(damage);
    }

    private void swapOpponents() {
        Droid newDefender = attacker;
        Droid newAttacker = defender;
        defender = newDefender;
        attacker = newAttacker;
    }

    private void printRoundInfo(int damage) {
        printSeparator();
        if (currentRound % 2 != 0)
            System.out.println("____________________________________");
        System.out.println("| Round " + (currentRound / 2 + 1));
        System.out.println(defender.getName() + " was hit by " + attacker.getName() + " with damage " + damage);
        System.out.println("| Defender: " + defender);
        System.out.println("| Attacker: " + attacker);
        System.out.println("|________________________________________|");
    }

    private void printWinnerInfo() {
        printSeparator();
        System.out.println("_____________________________");
        System.out.println("The winner is " + attacker.getName() + "!\n");
        System.out.println("_____________________________");
    }

    private void printSeparator() {
        System.out.println("----------------------------");
    }

    public Droid battleWinner() {
        return attacker;
    }
}
