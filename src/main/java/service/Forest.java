package service;

import models.Goblin;
import models.Human;
import models.Monster;
import models.Skeleton;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Forest {
    private static boolean end;

    public static void run(Human human) {
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

        System.out.println("1. One more fight\n2. Go home\n");

        try { //TODO jāsataisa lai ievad tik ilgi kamēr ir cipars
            menuPoint = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        switch (menuPoint) {
            case 1:
                System.out.println("turpinām kauju");
                break;
            case 2:
                System.out.println("atgriežamies mājās");
                end = true;
                break;
            default:
                System.out.println("ievadiet pareizu vērtību");
        }
    }
}
