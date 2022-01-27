import java.util.Random;
import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int sum = 0;

        System.out.print("Please enter the amount of dice to be rolled: ");
        int times = Integer.parseInt(kb.nextLine());

        System.out.print("Please enter the desired amount of sides of the die: ");
        int sides = Integer.parseInt(kb.nextLine());

        for(int i = 0; i < times; i++) {
            int roll = new Random().nextInt(sides) + 1;
            System.out.print(roll);
            if (i != times-1) {
                System.out.print(" + ");
            }
            else
                System.out.print(" = ");
            sum += roll;
        }

        System.out.print(sum);
        kb.close();
    }
}