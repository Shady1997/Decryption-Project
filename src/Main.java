import controller.DecryptionController;
import model.DecryptionModel;
import view.DecryptionView;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class Main {
    public static void main(String[] args) throws Exception {

        DecryptionView view = new DecryptionView();
        DecryptionModel model = new DecryptionModel();
        DecryptionController controller = new DecryptionController(view, model);
//        // Generate key
//        String key = generateKey();
//        System.out.println("Key: " + key);
//
//        // Encrypt message
//        String message = "Hello, world!";
//        String encryptedMessage = encrypt(key, message);
//        System.out.println("Encrypted Message: " + encryptedMessage);

    }
    // for demo
    public static String generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    private static final String ALGORITHM = "AES";

    public static String encrypt(String key, String message) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(key.getBytes(StandardCharsets.UTF_8));
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        byte[] encryptedMessage = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encryptedMessage);
    }
}