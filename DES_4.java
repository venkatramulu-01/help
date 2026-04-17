import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES_4 {
    public static void main(String[]args){
        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey=keyGenerator.generateKey();

            Cipher cipher=Cipher.getInstance("DES");

            Scanner sc=new Scanner(System.in);
            System.out.println("enter text to encrypt:");
            String s=sc.nextLine();

            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[]bytes=cipher.doFinal(s.getBytes());
            String e=Base64.getEncoder().encodeToString(bytes);
            System.out.println("encrypted text:"+e);

            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] db=cipher.doFinal(Base64.getDecoder().decode(e));

            String d=new String(db);
            System.out.println("decrypted text:"+d);

        }
        catch(Exception e){
            System.out.println("message:"+e.getMessage());
        }
    }
    
}
