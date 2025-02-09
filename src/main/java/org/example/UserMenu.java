package org.example;

import java.util.Scanner;

public class UserMenu {
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello");
        System.out.println("Press 1 for Encryption.");
        System.out.println("Press 2 for Decryption.");
        byte numChosen = -1;
        while (numChosen < 1 || numChosen > 2) {
            try {
                numChosen = scanner.nextByte();
                switch (numChosen) {
                    case 1:
                        Main.Encryption();
                        break;
                    case 2:
                        Main.Decryption();
                        break;
                    default:
                        System.out.println("Please select valid option: 1 or 2.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error,Please select valid number: 1 or 2.");
                scanner.next();
            }
        }
    }

}
