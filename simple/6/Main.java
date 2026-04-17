// package simple.6;
import java.util.*;
import java.security.MessageDigest;
public class Main {
    public static void main(String[]args){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("enter input:");
            String text=sc.nextLine();

            MessageDigest md=MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[]bt=md.digest();

            String hash=convert(bt);
            System.out.println("Hash of MD5 of "+text+":"+hash);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private static String convert(byte[]bt) throws Exception{
        StringBuilder sb=new StringBuilder();
        for(byte b:bt){
            sb.append(String.format("%02X",b));
        }
        return sb.toString();
    }

}
