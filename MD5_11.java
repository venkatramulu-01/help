import java.security.MessageDigest;
import java.util.Scanner;
public class MD5_11{
public static void main(String[]args){
    try{
        //Readinputfromuser
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter text to hash using MD5:");
        String input=scanner.nextLine();
        scanner.close();
        //CreateMD5MessageDigestinstance
        MessageDigest md=MessageDigest.getInstance("MD5");
        //Computehash
        md.update(input.getBytes());
        byte[]digest=md.digest();
        //Converttohexstring
        String hash= bytesToHex(digest);
        //Displayresult
        System.out.println("MD5 hash of\""+input+"\"is:");
        System.out.println(hash);
        }catch(Exception e){
        System.out.println("Error:"+e.getMessage());
        }
    }
    //Convertbytearraytohexadecimalstring
    public static String bytesToHex(byte[]bytes){
    StringBuilder hexString=new StringBuilder();
    for(byte b:bytes){
    hexString.append(String.format("%02X",b));
    }
    return hexString.toString();
    }
}