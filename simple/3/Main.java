// package simple.3;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
    private static  SecretKey generate() throws Exception{
        KeyGenerator kg=KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey sk=kg.generateKey();
        return sk;
        
    }
    private static String encrypt(SecretKey sk,String text) throws Exception{
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,sk);
        byte[]encb=cipher.doFinal(text.getBytes());
        String enc=Base64.getEncoder().encodeToString(encb);
        return enc;
    }
    private static String decrypt(SecretKey sk,String enc) throws Exception{
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,sk);

        byte[]decb=cipher.doFinal(Base64.getDecoder().decode(enc));
        String dec=new String(decb);
        return dec;
    }
    public static void main(String[]args){
        try{
            SecretKey key=generate();
            String text="Hello Rijndael";

            String enc=encrypt(key,text);
            System.out.println("encrypted text:"+enc);

            String dec=decrypt(key,enc);
            System.out.println("decrypted text:"+dec);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
