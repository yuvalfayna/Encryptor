package org.example;

public class FileEncryptor {
    public IEncryptionAlgorithm algorithm;

    public FileEncryptor(IEncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }


}
