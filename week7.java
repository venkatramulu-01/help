import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class week7 {
    public static void main(String[]args){
        try{
            String key="4510171189";
            String text="Hello World";
            //encryption
            SecretKeySpec secretKey=new SecretKeySpec(key.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[]enc=cipher.doFinal(text.getBytes());
            String etx= Base64.getEncoder().encodeToString(enc);
            System.out.println("encrypted text"+etx);

            //decryption
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] dc=cipher.doFinal(Base64.getDecoder().decode(etx));
            String dt=new String(dc);
            System.out.println("decrypted text:"+dt);


        }
        catch(Exception e){
            System.out.println("Message:"+e.getMessage());
        }
    }
    
}
