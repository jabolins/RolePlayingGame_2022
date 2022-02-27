package models;

import java.util.Random;

public abstract class Monster extends GameCharacter {
    public Monster(String name, int lives, int gold, int agility, int experience, int power) {
        super(name, lives, gold, agility, experience, power);
    }

   // Random random = new Random();

//    @Override
//    public String attack(GameCharacter gameCharacter) {
//
//        int rnd = random.nextInt(100);
//        if (rnd > agility * 3) {
//            return "did not hit";
//        }
//
//         gameCharacter.setLives(gameCharacter.getLives()-power);
//        if (gameCharacter.getLives()<=0){
//            return "win";
//        }
//        return "took " + power + " lives";
//    }

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
