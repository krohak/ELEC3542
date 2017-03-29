import java.util.*;
import java.io.Serializable;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignedObject;

public class RSASignatureDemo {

    public static void main(String[] args) throws Exception {
        String plainText = "Hello World";
        long startTime, endTime;


        // Alice signs the plainText using her private key
        startTime = System.currentTimeMillis();
        RSASignature aliceRSA = new RSASignature();
        KeyPair aliceKeyPair = aliceRSA.genPubKeys();
        SignedObject signedObject = aliceRSA.sign(plainText, aliceKeyPair.getPrivate());
        //endTime = System.currentTimeMillis();
        //System.out.println("The time needed for generating the signature for keysize 512 is " + (endTime-startTime) + " ms.");


        // Bob verifies the signature using Alice's public key
      //  startTime = System.currentTimeMillis();
        RSASignature bobRSA = new RSASignature();
        boolean verifyResult = bobRSA.verifySignature(signedObject, aliceKeyPair.getPublic());
        endTime = System.currentTimeMillis();
        System.out.println("The time needed for signing and verifying the RSA signature for keysize 512 is " + (endTime-startTime) + " ms.");

        if (verifyResult) {
            //System.out.println("Bob has verified the signed object.");
        } else {
            //System.out.println("The signature cannot be verified.");
        }

        System.out.println("");
        //System.out.println("Plaintext from signed object: " + signedObject.getObject());
    }

}
