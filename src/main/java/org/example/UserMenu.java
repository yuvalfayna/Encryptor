package org.example;

import java.util.Scanner;

public class UserMenu {
    // Convenient user menu method
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        //Types of Algorithms
        ShiftUpEncryption upEncryption = new ShiftUpEncryption();
        ShiftMultiplyEncryption multiplyEncryption = new ShiftMultiplyEncryption();
        DoubleEncryption doubleEncryption = new DoubleEncryption();
        XorEncryption xorEncryption = new XorEncryption();
        //Algorithms Execution Classes
        RepeatEncryption repeatEncryption = new RepeatEncryption(3,upEncryption);
        FileEncryptor fileEncryptor = new FileEncryptor(xorEncryption);

        System.out.println("Hello");
        System.out.println("Press 1 for Encryption.");
        System.out.println("Press 2 for Decryption.");
        byte numChosen = -1;
        while (numChosen < 1 || numChosen > 2) {
            try {
                numChosen = scanner.nextByte();
                switch (numChosen) {
                    case 1:
                        fileEncryptor.algorithm.EncryptionAlgorithm(FilesOperations.UserPathFileReaderEncryption(),repeatEncryption.n);
                        break;
                    case 2:
                        fileEncryptor.algorithm.DecryptionAlgorithm(FilesOperations.UserPathFileReaderDecryption());                        break;
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
