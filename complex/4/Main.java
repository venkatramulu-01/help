// package complex.4;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
public class Main {
    public static void main(String[]args){
        try{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the text:");
        String text=sc.nextLine();

        String key="secretkey";
        SecretKeySpec sk=new SecretKeySpec(key.getBytes(),"Blowfish");

        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE,sk);
        byte[]bt=cipher.doFinal(text.getBytes());
        String enc=Base64.getEncoder().encodeToString(bt);
        System.out.println("encrypted:"+enc);

        cipher.init(Cipher.DECRYPT_MODE,sk);
        byte[]dbt=cipher.doFinal(Base64.getDecoder().decode(enc));
        String dec=new String(dbt);
        System.out.println("decrypted:"+dec);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
