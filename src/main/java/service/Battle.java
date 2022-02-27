package service;

import models.Goblin;
import models.Human;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private static boolean end = false;

    public static void fight(Human human) {
        end=false;
        while (!end) { // TODO te jāuztaisa lai reizēm ir skelets, reizēm goblins
            Goblin goblin = new Goblin("G", 100, 120, 20, 10, 25);

            if(isGoblinAttackFirst()){
                System.out.println("Goblin " + goblin.attack(human));
            }

            while (true) {
                System.out.println("Human " + human.attack(goblin));
                if (goblin.getLives() <= 0) break;
                System.out.println("Goblin " + goblin.attack(human));
                if (human.getLives() <= 0){
                    end = true;
                    System.out.println("You lose");
                    break;
                }
            }
            if (human.getLives()<=0) break;

            System.out.println(human);
            System.out.println(goblin);

            menu(human);
        }
    }

    private static boolean isGoblinAttackFirst() {
        Random random = new Random();
        if (random.nextInt(2) % 2 == 0) {
            boolean result =true;
        }
        return false;
    }

    private static void menu(Human human) {
        Scanner scanner = new Scanner(System.in);
        int menuPoint=0;

        System.out.println("1. One more fight\n2. Go home\n");

        try {
            menuPoint = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        switch (menuPoint){
            case 1:
                System.out.println("turpinām kauju");
                break;
            case 2:
                System.out.println("atgriežamies mājās");
                end= true;
                break;
            default:
                System.out.println("ievadiet pareizu vērtību");
        }
    }
}
