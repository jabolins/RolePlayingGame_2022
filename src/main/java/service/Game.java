package service;

import models.Human;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private static boolean end;
    private Human human;

    public void run() {
        end = false;
        createUserHuman();

        while (!end) {
            if (human.getLives() <= 0) {
                System.out.println("Game over");
                break;
            } else {
                printMenu();
            }
        }
    }

    private void createUserHuman() {
        System.out.println("Please write name of your hero");
        String heroName = scanner.nextLine();
        human = new Human(heroName, 100, 10, 25, 0, 40);
    }

    private void printMenu() {
        int menuPoint;
        menuPoint = userChoice();

        switch (menuPoint) {
            case 1:
                goingToShop(human);
                break;
            case 2:
                goingToForest(human);
                break;
            case 3:
                end = true;
                break;
            default:
                System.out.println("incorrect value");
        }
    }

    private int userChoice() {
        int userChoice = 0;
        while (userChoice != 1 && userChoice != 2 && userChoice != 3) {
            System.out.println("1. Go to Go to shop\n2. Go to dark forest\n3. Exit");
            try {
                userChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Number entered was not an integer");
                scanner.next();
            }
        }
        return userChoice;
    }

    private void goingToShop(Human human) {
        System.out.println("Going to shop");
        Shop shop = new Shop(human);
        shop.buy();
    }

    private void goingToForest(Human human) {
        System.out.println("Going to forest");
        Forest forest = new Forest(human);
        Thread thread = new Thread(forest);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
