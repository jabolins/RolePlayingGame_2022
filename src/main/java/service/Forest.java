package service;

import models.Goblin;
import models.Human;
import models.Monster;
import models.Skeleton;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Forest {

    public Forest(Human human) {
        this.human = human;
    }

    private Human human;
    private static boolean end;

    public void run() {
        Monster monster;
        end = false;

        while (!end) {

            monster = goblinOrSkeleton();

            if (isMonsterAttackFirst()) {
                monster.attack(human);
                if (human.getLives() <= 0) {
                    end = true;
                    System.out.println("You lose");
                    break;
                }
            }

            while (true) {
                human.attack(monster);
                if (monster.getLives() <= 0) {
                    System.out.println("You vin");
                    human.setGold(human.getGold() + monster.getGold());
                    human.setExperience(human.getExperience() + monster.getPower());
                    break;
                }

                monster.attack(human);
                if (human.getLives() <= 0) {
                    end = true;
                    System.out.println("You lose");
                    break;
                }
            }

            if (human.getLives() <= 0) break;

            System.out.println(human);
            System.out.println(monster);

            menu();
        }
    }

    private static Monster goblinOrSkeleton() {
        Monster monster;
        Random random = new Random();
        if (random.nextInt(2) % 2 == 0) {
            monster = new Goblin();
        } else {
            monster = new Skeleton();
        }
        return monster;
    }

    private static boolean isMonsterAttackFirst() {
        Random random = new Random();
        if (random.nextInt(2) % 2 == 0) {
            return true;
        }
        return false;
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int menuPoint = 0;


        while (menuPoint != 1 && menuPoint != 2) {
            System.out.println("1. One more fight\n2. Go home\n");
            try {
                menuPoint = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Number entered was not an integer");
                scanner.next();
            }
        }

        switch (menuPoint) {
            case 1:
                System.out.println("One more fight! Yes!");
                break;
            case 2:
                System.out.println("Going to home");
                end = true;
                break;
            default:
                System.out.println("incorrect value");
        }

    }
}
