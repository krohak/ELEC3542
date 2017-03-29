import java.io.Serializable;

import javax.crypto.SecretKey;
import javax.crypto.SealedObject;

public class AESEncryptionDemo {

    public static void main(String[] args) throws Exception {
      long startTime, endTime;
        // Alice generates the encrypted text using a secret key shared with Bob
        AESEncryption alice = new AESEncryption();
        // Bob decrypts the ciphertext using the shared secret
        AESEncryption bob = new AESEncryption();

        String plainText = "Hello World";

        // Alice and Bob get their shared secret separately from the same password "alice&bob"
        SecretKey aliceKey = alice.getSecretEncryptionKey("alice&bob");
        SecretKey bobKey = aliceKey;
        //bob.getSecretEncryptionKey("alice&bob");

        startTime = System.currentTimeMillis();
        // Alice performs encryption using the shared key maintained by herself
        SealedObject cipherObject = alice.encrypt(plainText, aliceKey);
        endTime = System.currentTimeMillis();
        System.out.println("The time needed for encryption for keysize 128 is " + (endTime-startTime) + " ms.");

        // Bob performs decryption using the shared key maintained by himself
        startTime = System.currentTimeMillis();
        String decryptedText = (String) bob.decrypt(cipherObject, bobKey);
        endTime = System.currentTimeMillis();
        System.out.println("The time needed for decryption for keysize 128 is " + (endTime-startTime) + " ms.");

        //System.out.println("Original Text:" + plainText);
        //System.out.println("Decrypted Text:" + decryptedText);
    }

}
