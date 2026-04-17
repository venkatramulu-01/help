import java.security.MessageDigest;
import java.util.*;
public class SHA_10 {
    private static String bytetoHex(byte[]bytes){
        StringBuilder sb=new StringBuilder();
        for(byte x:bytes){
            sb.append(String.format("%02X",x));                     
        }
        return sb.toString();
    }
    public static void main(String[]args){
        try{
        Scanner sc=new Scanner(System.in);
        MessageDigest md= MessageDigest.getInstance("SHA-1");
        System.out.println("enter the string to use SHA-1");

        String s=sc.nextLine();
        md.update(s.getBytes());
        byte[] bytes=md.digest();
        String hash=bytetoHex(bytes);
        System.out.println("SHA-1 of "+s+"is:"+hash);

        }
        catch(Exception e){
            System.out.println("message:"+e.getMessage());
        }
    }
}
