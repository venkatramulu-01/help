import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
public class Rijndel_6{
//GenerateasecretAESkey
    public static SecretKey generateKey()throws Exception{
        KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
        keyGenerator.init(128);//AES-128bitkey
        return keyGenerator.generateKey();
    }
//EncryptplaintextusingAES
    public static String encrypt(String plainText,SecretKey secretKey)throws Exception{
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[]encryptedBytes=cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    //DecryptciphertextusingAES
    public static String decrypt(String encryptedText,SecretKey secretKey)throws Exception{
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[]decryptedBytes=cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
    public static void main(String[]args){
        try{
            SecretKey secretKey=generateKey();
            String originalText="Hello,RijndaelAES!";
            String encryptedText= encrypt(originalText,secretKey);
            System.out.println("Encrypted:"+encryptedText);
            String decryptedText= decrypt(encryptedText,secretKey);
            System.out.println("Decrypted:"+decryptedText);
        }catch(Exception e){
                e.printStackTrace();
        }
    }
}

