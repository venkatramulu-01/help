//package simple.2;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;

public class Main {

    public static void main(String[]args){
        try{
            Scanner sc=new Scanner(System.in);
            KeyGenerator kg=KeyGenerator.getInstance("DES");
            kg.init(56);
            SecretKey sk=kg.generateKey();

            Cipher cipher=Cipher.getInstance("DES");
            System.out.println("enter the text:");
            String text=sc.nextLine();

            cipher.init(Cipher.ENCRYPT_MODE,sk);
            byte[]encb=cipher.doFinal(text.getBytes());
            String enc=Base64.getEncoder().encodeToString(encb);
            System.out.println("encrypted text:"+enc);

            cipher.init(Cipher.DECRYPT_MODE,sk);
            byte[]decb=cipher.doFinal(Base64.getDecoder().decode(enc));
            String dec=new String(decb);
            System.out.println("decrypted text:"+dec);
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
