package org.example;

public class RepeatEncryption {
    public int n;
    public IEncryptionAlgorithm algorithm;

    public RepeatEncryption(int n, IEncryptionAlgorithm algorithm) {
        this.n = n;
        this.algorithm = algorithm;
    }

}
