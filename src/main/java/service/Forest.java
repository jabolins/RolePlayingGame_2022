package service;

import models.Goblin;
import models.Human;
import models.Monster;
import models.Skeleton;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Forest implements Runnable {

    public Forest(Human human) {
        this.human = human;
    }

    private final Human human;
    private Monster monster;

    private static boolean end;

    public void run() {
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
                    System.out.println(human.getName() + " win");
                    human.setGold(human.getGold() + monster.getGold());
                    human.setExperience(human.getExperience() + monster.getPower());
                    if (human.getExperience() >= 100) {
                        human.levelUp();
                    }
                    break;
                }

                monster.attack(human);
                if (human.getLives() <= 0) {
                    end = true;
                    System.out.println(human.getName() + " lost");
                    break;
                }
            }

            if (human.getLives() <= 0) break;

            printMenu();
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
        return random.nextInt(2) % 2 == 0;
    }

    private static void printMenu() {
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
