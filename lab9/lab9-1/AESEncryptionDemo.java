import java.io.Serializable;

import javax.crypto.SecretKey;
import javax.crypto.SealedObject;

public class AESEncryptionDemo {

    public static void main(String[] args) throws Exception {
      long startTime, endTime;
      String plainText = "Hello World";

        // Alice generates the encrypted text using a secret key shared with Bob
        startTime = System.currentTimeMillis();
        AESEncryption alice = new AESEncryption();
        // Bob decrypts the ciphertext using the shared secret
        AESEncryption bob = new AESEncryption();


        // Alice and Bob get their shared secret separately from the same password "alice&bob"
        SecretKey aliceKey = alice.getSecretEncryptionKey("alice&bob");
        SecretKey bobKey = aliceKey;
        //bob.getSecretEncryptionKey("alice&bob");


        // Alice performs encryption using the shared key maintained by herself
        SealedObject cipherObject = alice.encrypt(plainText, aliceKey);
        //endTime = System.currentTimeMillis();
        //System.out.println("The time needed for encryption for keysize 128 is " + (endTime-startTime) + " ms.");

        // Bob performs decryption using the shared key maintained by himself
      //  startTime = System.currentTimeMillis();
        String decryptedText = (String) bob.decrypt(cipherObject, bobKey);
        endTime = System.currentTimeMillis();
        System.out.println("The time needed for encryption and decryption for AES keysize 128 is " + (endTime-startTime) + " ms.");

        //System.out.println("Original Text:" + plainText);
        //System.out.println("Decrypted Text:" + decryptedText);
    }

}
