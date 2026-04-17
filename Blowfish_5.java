import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;
class Blowfish_5{
    public static void main(String[]args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("enter the string:");
            String inputString=sc.nextLine();
            
            String secretKey="custom-key-123";
            SecretKeySpec keySpec=new SecretKeySpec(secretKey.getBytes(),"Blowfish");
            Cipher encryptCipher=Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE,keySpec);

            byte[] encryptedBytes=encryptCipher.doFinal(inputString.getBytes());
            String encryptedValue=Base64.getEncoder().encodeToString(encryptedBytes);
            


            Cipher decryptCipher=Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE,keySpec);

            byte[] decrypedBytes=decryptCipher.doFinal(encryptedBytes);
            String decryptedValue=new String(decrypedBytes);

            System.out.println("String:"+inputString);
            System.out.println("encrypted String:"+encryptedValue);
            System.out.println("decrypted String:"+decryptedValue);
        }
        catch(Exception e){
            System.out.println("error:"+e.getMessage());    
        }
    }
}