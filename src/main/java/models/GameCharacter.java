package models;

import java.util.Random;

public abstract class GameCharacter {
    protected String name;
    protected int lives;
    protected int gold;
    protected int agility;
    protected int experience;
    protected int power;

    public GameCharacter(String name, int lives, int gold, int agility, int experience, int power) {
        this.name = name;
        this.lives = lives;
        this.gold = gold;
        this.agility = agility;
        this.experience = experience;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int attack(GameCharacter gameCharacter) {
        Random random = new Random();
        int rnd = random.nextInt(100);
        if (rnd > agility * 3) {
            System.out.println(this.getName() + " did not hit");
            return 0;
        }

        gameCharacter.setLives(gameCharacter.getLives() - power);
        System.out.println((this.getName()+ " took "+ power + "lives"));
        return power;
    }
}
