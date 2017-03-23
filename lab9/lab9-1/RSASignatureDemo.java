import java.util.*;
import java.io.Serializable;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignedObject;

public class RSASignatureDemo {

    public static void main(String[] args) throws Exception {
        String plainText = "Hello World";

        // Alice signs the plainText using her private key
        RSASignature aliceRSA = new RSASignature();
        KeyPair aliceKeyPair = aliceRSA.genPubKeys();
        SignedObject signedObject = aliceRSA.sign(plainText, aliceKeyPair.getPrivate());

        // Bob verifies the signature using Alice's public key
        RSASignature bobRSA = new RSASignature();
        boolean verifyResult = bobRSA.verifySignature(signedObject, aliceKeyPair.getPublic());

        if (verifyResult) {
            System.out.println("Bob has verified the signed object.");
        } else {
            System.out.println("The signature cannot be verified.");
        }

        System.out.println("Original plaintext : " + plainText);
        System.out.println("Plaintext from signed object: " + signedObject.getObject());
    }

}
