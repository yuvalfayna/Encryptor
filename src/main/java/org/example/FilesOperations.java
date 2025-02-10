package org.example;

import org.apache.commons.io.FilenameUtils;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class FilesOperations {
    // ********************Encryption Methods********************

    // Method of user input path of unencrypted file
    public static File UserPathFileReaderEncryption() {
        Scanner pathReader = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            System.out.println("Please enter the path of the file you want to encrypt (include the file extension).");
            File file = new File(pathReader.nextLine());
            if (file.exists() && file.isFile()) {
                success = true;
                return file;
            } else {
                System.out.println("File not found, Please try again");
            }
        }
        return null;
    }

    // Method of creating key file for encrypted file
    public static int CreateKeyFile(File originfile) {
        Random random = new Random();
        int key = random.nextInt(100, 300);
        try {
            File keyfile = new File(originfile.getParent() + "\\" + originfile.getName() + "_key.txt");
            if (keyfile.createNewFile()) {
                System.out.println("Key File Name - " + keyfile.getName());
                System.out.println("Key File Path - " + keyfile.getParent());
                try (FileWriter fileWriter = new FileWriter(keyfile)) {
                    fileWriter.write(Integer.toString(key));
                    return key;
                } catch (IOException e) {
                    System.out.println("Error = " + e.getMessage());
                }
            } else {
                System.out.println("Key already encrypted, please try another file path");
                exit(2);
            }
        } catch (Exception e) {
            System.out.println("Error = " + e.getMessage());
        }
        return 0;
    }

    // Method of creating encrypted file
    public static File CreateEncryptedFile(File originfile) {
        try {
            String extension = FilenameUtils.getExtension(originfile.getPath());
            File encryptedfile = new File(originfile.getParent() + "\\" + originfile.getName() + "_encrypted." + extension);
            if (encryptedfile.createNewFile()) {
                System.out.println("Encrypted File Name - " + encryptedfile.getName());
                System.out.println("Encrypted File Path - " + encryptedfile.getParent());
                return encryptedfile;
            } else {
                System.out.println("File already encrypted, please try another file path");
                exit(1);

            }
        } catch (Exception e) {
            System.out.println("Error = " + e.getMessage());
        }
        return null;
    }
    //********************Decryption Methods********************

    // Method of user input path of encrypted file
    public static File UserPathFileReaderDecryption() {
        Scanner pathReader = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            System.out.println("Please enter the path of the file you want to decrypt (include the file extension).");
            File file = new File(pathReader.nextLine());
            if (file.exists() && file.isFile()) {
                success = true;
                return file;
            } else {
                System.out.println("File not found, Please try again");
            }
        }
        return null;
    }
    // Method of reading Key value of encrypted file
    public static int KeyReader() {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            System.out.println("Please enter the path of the file's key you want to decrypt (include the file extension).");
            File file = new File(scanner.nextLine());
            if (file.exists() && file.isFile()) {
                success = true;
                try {
                    scanner = new Scanner(file);
                    return Integer.parseInt(scanner.next());
                } catch (FileNotFoundException e) {
                    System.out.println("File not found = " + e.getMessage());
                }
            } else {
                System.out.println("File not found, Please try again");
            }
        }
        return 0;
    }

    // Method of creating decrypted file
    public static File CreateDecryptedFile(File originfile) {
        try {
            String extension = FilenameUtils.getExtension(originfile.getPath());
            File decryptedfile = new File(originfile.getParent() + "\\" + originfile.getName() + "_decrypted." + extension);
            if (decryptedfile.createNewFile()) {
                System.out.println("Decrypted File Name - " + decryptedfile.getName());
                System.out.println("Decrypted File Path - " + decryptedfile.getParent());
                return decryptedfile;
            } else {
                System.out.println("File already decrypted");
            }
        } catch (Exception e) {
            System.out.println("Error = " + e.getMessage());
        }
        return null;
    }
}




