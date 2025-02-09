package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptionDecryptionAlgorithm {
    public static void EncryptionAlgorithm(File originfile) {
        int key = FilesOperations.CreateKey(originfile);
        File encryptedfile = FilesOperations.CreateEncryptedFile(originfile);
        try {
            Scanner scanner = new Scanner(originfile);
            scanner.useDelimiter("");
            try (FileWriter fileWriter = new FileWriter(encryptedfile)) {
                while (scanner.hasNext()) {
                    char c = (char) (scanner.next().charAt(0) + key);
                    fileWriter.write(c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error = " + e.getMessage());
        }
    }
    public static void DecryptionAlgorithm(File originfile){
        int key = FilesOperations.KeyReader();
        File decryptedFile = FilesOperations.CreateDecryptedFile(originfile);
        try{
            Scanner scanner = new Scanner(originfile);
            scanner.useDelimiter("");
            try (FileWriter fileWriter = new FileWriter(decryptedFile)) {
                while (scanner.hasNext()){
                    char c = (char) (scanner.next().charAt(0) - key);
                    fileWriter.write(c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error = " + e.getMessage());
        }
    }

}
