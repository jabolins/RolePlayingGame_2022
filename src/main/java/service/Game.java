package service;

import models.Human;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static boolean end;

    public void run() {
        end = false;
        Human human = new Human("A", 100, 10, 25, 0, 40);//TODO jāsataisa lai izveido pats cilvēku

        while (!end) {
            if (human.getLives() <= 0) {
                System.out.println("Game over");
                break;
            }
            menu(human);
        }
    }

    private void menu(Human human) {
        Scanner scanner = new Scanner(System.in);
        int menuPoint = 0;

        while (menuPoint!=1 && menuPoint!=2 && menuPoint!=3) {
            System.out.println("1. Go to Go to shop\n2. Go to dark forest\n3. Exit");

            try {
                menuPoint = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Number entered was not an integer");
                scanner.next();
            }
        }

        switch (menuPoint) {
            case 1:
                System.out.println("Going to shop");
               Shop shop = new Shop(human);
                shop.buy();
                break;
            case 2:
                System.out.println("Going to forest");
                Forest forest = new Forest(human);
                forest.run();
                break;
            case 3:
                end = true;
                break;
            default:
                System.out.println("incorrect value");
        }
    }
}
