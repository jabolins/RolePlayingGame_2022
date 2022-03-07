package service;

import models.Human;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {

    private final Human human;
    private static boolean end;
    private static final Scanner scanner = new Scanner(System.in);
    /**
     * value how many gold cost one live
     */
    private static int transactionRate = 2;

    public Shop(Human human) {
        this.human = human;
    }

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
                    buylives();
                    break;
                case 2:
                    System.out.println("Go home");
                    end = true;
                    break;
                default:
                    System.out.println("incorrect value");
            }
        }
    }

    private void buylives() {
        int countOfLives = -1;
        System.out.println("Today's price is "+ transactionRate + " gold per live");

        while(countOfLives<0 || countOfLives>canBuyLives()){
            System.out.println("You can buy " + canBuyLives() + " of lives\nHow much lives do you want to buy?");
            try {
                countOfLives = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Number entered was not an integer");
                scanner.next();
            }
        }

        human.setLives(human.getLives() + countOfLives);
        human.setGold(human.getGold() - countOfLives * transactionRate);
    }

    private int canBuyLives() {
        int toFullLife = human.getMaximumLives() - human.getLives();
        int goldForDeal = human.getGold() / transactionRate;
        if (toFullLife < goldForDeal) return toFullLife;
        else return goldForDeal;
    }
}
