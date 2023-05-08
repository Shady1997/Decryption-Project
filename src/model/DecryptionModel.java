package model;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DecryptionModel {

    private static final String ALGORITHM = "AES";

    public String decrypt(String key, String encryptedText) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key.getBytes(StandardCharsets.UTF_8));
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, originalKey);
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(encryptedText.getBytes(StandardCharsets.UTF_8)));

        return new String(decryptedText, StandardCharsets.UTF_8);
    }
}

