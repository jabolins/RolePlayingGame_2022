package models;

import java.util.Random;

public class Human extends GameCharacter {
    private int level;
    private int maximumLevel;

    public Human(String name, int lives, int gold, int agility, int experience, int power) {
        super(name, lives, gold, agility, experience, power);
        this.level = 1;
        this.maximumLevel = 100;
    }

    Random random=new Random();

    @Override
    public String attack(GameCharacter gameCharacter) {

        int rnd=random.nextInt(100);
        if (rnd>agility*3){
            return "did not hit";
        }

        gameCharacter.setLives(gameCharacter.getLives() - power);
        if (gameCharacter.getLives() <= 0) {
            gold+=gameCharacter.getGold();
            experience+= 34; /// TODO šeit jāizdomā kāds būs pieredzes skaits un kā to noteikt
            return "win";
        }

        return "took " + power + " lives";
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lives=" + lives +
                ", gold=" + gold +
                ", agility=" + agility +
                ", experience=" + experience +
                ", power=" + power +
                ", level=" + level +
                ", maximumLevel=" + maximumLevel +
                '}';
    }
}
