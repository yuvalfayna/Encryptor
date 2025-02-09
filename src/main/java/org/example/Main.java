package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        UserMenu.Menu();
    }

    public static void Encryption() {
        File file = FilesOperations.UserPathFileReaderEncryption();
        EncryptionDecryptionAlgorithm.EncryptionAlgorithm(file);
    }

    public static void Decryption() {
        File file = FilesOperations.UserPathFileReaderDecryption();
        EncryptionDecryptionAlgorithm.DecryptionAlgorithm(file);
    }
}
