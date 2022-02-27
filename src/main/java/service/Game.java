package service;

import models.Human;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private static boolean end = false;

    public void run() {
        end = false;
        Human human = new Human("A", 100, 10, 20, 0, 30);

        while (!end) {

            if (human.getLives()<=0){
                break;
            }
            menu(human);
        }
    }

    private void menu(Human human) {
        Scanner scanner = new Scanner(System.in);
        int menuPoint = 0;

        System.out.println("1. Go to Go to shop\n2. Go to dark forest\n3. Exit");

        try {
            menuPoint = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Number entered was not an integer"); //TODO jāuztaisa lai nevar ievadīt burtu
            //e.printStackTrace();
        }
        switch (menuPoint) {
            case 1:
                System.out.println("uz veikalu");
                Shop.buy(human);
                break;
            case 2:
                System.out.println("uz mežu");
                Battle.fight(human);
                break;
            case 3:
                end = true;
                break;
            default:
                System.out.println("nepareiza izvēle, izvēlieties no 1 līdz 3");
        }
    }


}
