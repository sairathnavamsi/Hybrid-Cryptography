package Encryption;
import java.math.BigInteger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class encryption_phase {
    private static final String ALGORITHM = "Blowfish";
    private static String keyString;

    public static void encrypt(File inputFile, File outputFile) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile);
        System.out.println("File encrypted successfully!");
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
        System.out.println("Enter the blowfish key to Encrypt the file:");
        String s1 = in.nextLine();
        BigInteger  n, phi, u, p, q, ua, b;
        int j;
        BigInteger t = new BigInteger("1");
        p = new BigInteger("11");
        q = new BigInteger("7");
        n = p.multiply(q);
        phi = (p.subtract(t)).multiply(q.subtract(t));
        int e1 = 7;
        u = new BigInteger("3");
        int a = 31;
        ua = u.pow(a);
        BigInteger[] ekey = new BigInteger[100];
        BigInteger[] enkey = new BigInteger[100];
        File inputFile = new File("C:/Users/saira/isaa/isaa/src/docs.rar");
        File encryptedFile = new File("C:/Users/saira/isaa/isaa/src/file.encrypted");

        try {
            encryption_phase.keyString = s1;
            encryption_phase.encrypt(inputFile, encryptedFile);
            for (j = 0; j < s1.length(); j++) {
                ekey[j] = BigInteger.valueOf((int) s1.charAt(j));
            }
            System.out.println("Your Encrypted key using SRNN is:");
            for (j = 0; j < s1.length(); j++) {
                b = (ekey[j].multiply(ua)).pow(e1);
                enkey[j] = b.mod(n);
                System.out.println(enkey[j]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
