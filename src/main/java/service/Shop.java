package service;

import models.Human;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {
    public Shop(Human human) {
        this.human = human;
    }

    private Human human;

    private static boolean end;
    private static int transactionRate = 2;
    private static Scanner scanner = new Scanner(System.in);

    public void buy() {
        end = false;

        while (!end) {

            int menuPoint = 0;
            while (menuPoint!=1 && menuPoint!=2) {
                System.out.println("1. Buy lives\n2. Go back");
                try {
                    menuPoint = scanner.nextInt();
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

    private static void buyLIves(Human human) {


       // canBuyLives(human);
        System.out.println("Today's price is "+ transactionRate+ " gold per life");
        System.out.println("You can buy " + canBuyLives(human) + " of lives\nHow much lives do you want to buy?");
        int countOfLives = 0;
        try {
            countOfLives = scanner.nextInt(); // TODO te jāizdomā pārbaude lai nenopērk variāk kā var
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
