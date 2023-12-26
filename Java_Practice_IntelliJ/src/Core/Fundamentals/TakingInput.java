package Core.Fundamentals;

import java.util.Scanner;

public class TakingInput {
    public static void show(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter you name: ");
        String name = scanner.next();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.printf("Name : %s , Age : %d",name,age);

        scanner.close();


    }
}

