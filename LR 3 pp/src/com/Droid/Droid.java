package com.Droid;

import java.util.Random;

public class Droid {
    private String name;
    private int health;
    private int maxDamage;
    private int healthBeforeFight;

    private static Random random = new Random();

    public Droid(String name, int health, int maxDamage) {
        this.name = name;
        this.health = health;
        this.maxDamage = maxDamage;
        healthBeforeFight = health; // відновлює повністю здоров'я дроїда після битви
    }
    //отримуємо значення під час бою
    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealthBeforeFight() {
        return healthBeforeFight;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return random.nextInt(maxDamage + 1);
    }

    public void getHit(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    @Override
    public String toString() {
        return "Droid \n[" + "name = '" + name + "]\n" + "[health = " + health + "]\n[maxDamage = " + maxDamage + "]\n";
    }
}

