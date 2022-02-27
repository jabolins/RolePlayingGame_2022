package service;

import models.Human;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {

    private static boolean end;
    private static int transactionRate = 2;
    private static Scanner scanner = new Scanner(System.in);

    public static void buy(Human human) {
        end = false;
        System.out.println("iepērkamies"); //TODO šis pārbaudei, vēlāk jāizdzēš

        while (!end) {

            int menuPoint = 0;
            System.out.println("1. Buy lives\n2. Go back");

            while (true) {
                try {
                    menuPoint = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Number entered was not an integer");
                    scanner.next();
                }
            }

            switch (menuPoint) {
                case 1:
                    buyLIves(human);
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

    private static void buyLIves(Human human) { //TODO te jāizdomā par kaut kādu koeficientu


        canBuyLives(human);
        System.out.println("You can buy " + canBuyLives(human) + "  of lives\nHow much lives do you want to buy?"); // TODO jāpievieno ka nav pa daudz dzīvību
        int countOfLives = 0;
        try {
            countOfLives = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        human.setLives(human.getLives() + countOfLives);
        human.setGold(human.getGold() - countOfLives * transactionRate);
        System.out.println(human);
    }

    private static int canBuyLives(Human human) {
        int toFullLife = human.getMaximumLives() - human.getLives();
        int goldForDeal = human.getGold() / transactionRate;
        if (toFullLife < goldForDeal) return toFullLife;
        else return goldForDeal;
    }
}
