package org.example;

import java.io.File;

public interface IEncryptionAlgorithm {
    //    Interface for encryption file
    void EncryptionAlgorithm(File originfile);

    void EncryptionAlgorithm(File originfile, int n);

    void DecryptionAlgorithm(File originfile);

}
