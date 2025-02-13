package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DoubleEncryption implements IEncryptionAlgorithm {
    // Method of encryption algorithm
    public void EncryptionAlgorithm(File originfile) {
        boolean isRenamed = false;
        File encryptedfile = new File(originfile.getPath());
        for (int i = 0; i < 2; i++) {
            int key = FilesOperations.CreateKeyFile(originfile);
            System.out.println(key);
            if (!isRenamed) {
                encryptedfile = FilesOperations.CreateEncryptedFile(originfile);
            }
            try {
                Scanner scanner = new Scanner(originfile);
                scanner.useDelimiter("");
                try (FileWriter fileWriter = new FileWriter(encryptedfile)) {
                    while (scanner.hasNext()) {
                        char c = (char) (scanner.next().charAt(0) + key);
                        System.out.println(c);
                        fileWriter.write(c);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Error = " + e.getMessage());
            }
            if (!isRenamed) {
                String path = originfile.getParent() + "\\" + originfile.getName() + "_key.txt";
                File keyfile = new File(path);
                File firstkey = new File(originfile.getParent() + "\\" + originfile.getName() + "_firstkey.txt");
                isRenamed = keyfile.renameTo(firstkey);
            }
        }
    }

    // Method of RepeatEncryption
    public void EncryptionAlgorithm(File originfile, int n) {
    }

    // Method of decryption algorithm
    public void DecryptionAlgorithm(File originfile) {

    }
}
