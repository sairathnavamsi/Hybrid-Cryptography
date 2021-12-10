package Decryption;
import java.math.BigInteger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class decryption_phase {
    private static final String ALGORITHM = "Blowfish";
    private static String keyString;


    public static void decrypt(File inputFile, File outputFile) throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile);
        System.out.println("File decrypted successfully!");
    }

    private static void doCrypto(int cipherMode, File inputFile, File outputFile) throws Exception {
        Key secretKey = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(cipherMode, secretKey);
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
        byte[] outputBytes = cipher.doFinal(inputBytes);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
        inputStream.close();
        outputStream.close();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int num;
        BigInteger  n, phi, u, p, q, v;
        int j;
        String encrypt = "";
        BigInteger t = new BigInteger("1");
        p = new BigInteger("11");
        q = new BigInteger("7");
        n = p.multiply(q);
        phi = (p.subtract(t)).multiply(q.subtract(t));
        int e1 = 7;
        int d = 43;
        u = new BigInteger("3");
        int a = 31;
        BigInteger[] arr = new BigInteger[100];
        BigInteger[] dearr = new BigInteger[100];
        File encryptedFile = new File("C:/Users/saira/isaa/isaa/src/file.encrypted");
        File decryptedFile = new File("C:/Users/saira/isaa/isaa/src/decrypted_docs.rar");
        System.out.println("To decrypt your file Enter the SRNN key generated:");
        v = (u.pow(phi.intValue() - a)).mod(n);
        System.out.println("Enter the number of keys to decrypt the file:");
        num = in.nextInt();
        System.out.println("Enter the values:");
        for (j = 0; j < num; j++) {
            arr[j] = in.nextBigInteger();
        }
        for (j = 0; j < num; j++) {
            dearr[j] = (((v.pow(e1)).multiply(arr[j])).pow(d)).mod(n);
            encrypt = encrypt + (char) dearr[j].intValue();
        }
        System.out.println("Your blowfish key is: " + encrypt);
        try {
            decryption_phase.keyString = encrypt;
            decryption_phase.decrypt(encryptedFile, decryptedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}