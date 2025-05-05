package ui;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static String readText(String prompt){
        System.out.println(prompt);
        sc.nextLine();
        return sc.nextLine();
    }

    public static int readChoices(String prompt, String... choices){
        if (prompt != null){
            System.out.println(prompt);
        }
        int choice;
        do{
            System.out.println("Vyber si možnost:");
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i+1) + ": " + choices[i]);
            }
            //aby bylo human-readable
            choice = sc.nextInt()-1;
        } while (choice < 0 || choice >= choices.length);
        return choice;
    }
}
