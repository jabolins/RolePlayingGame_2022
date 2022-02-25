import models.Goblin;
import models.Human;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Human human= new Human("A",100,10,20,0,30);
        Goblin goblin= new Goblin("G",100,30,20,10,30);

        Random random= new Random();

        if (random.nextInt(2)%2==0){
            System.out.println("Golin "+goblin.attack(human));
        }

        while (true){
            System.out.println("Human "+ human.attack(goblin));
            if (goblin.getLives()<=0) break;
            System.out.println("Golin "+goblin.attack(human));
            if (human.getLives()<=0) break;
        }

        System.out.println(human);
        System.out.println(goblin);
    }
}
