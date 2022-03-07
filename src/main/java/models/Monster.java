package models;

import java.util.Random;

public abstract class Monster extends GameCharacter {
    public Monster(String name, int lives, int gold, int agility, int experience, int power) {
        super(name, lives, gold, agility, experience, power);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", lives=" + lives +
                ", gold=" + gold +
                ", agility=" + agility +
                ", experience=" + experience +
                ", power=" + power +
                '}';
    }
}
