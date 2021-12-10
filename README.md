# Hybrid Asymmetric Cryptography Algorithm
Java implementation of a custom hybrid cryptography algorithm that uses a combination of Blowfish and SRNN. It supports encryption and decryption of specified path. The encryptor first encrypts data using blowfish algorithm and the generated blowfish key is encrypted using SRNN algorithm to output encrypted file and SRNN keys. The decryptor takes encrypted file and SRNN keys to reverse the process and retrieve the original data.

###Requirements
- VS Code
- Java Crypto library
