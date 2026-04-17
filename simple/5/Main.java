// package simple.5;
import java.security.MessageDigest;
import java.util.*;

public class Main {
    public static void main(String[]args){
        try{
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();

        MessageDigest md=MessageDigest.getInstance("SHA-1");
        md.update(input.getBytes());
        byte[] bt=md.digest();
        String hash=convert(bt);
        System.out.println(input+" hash:"+hash);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private static String convert(byte bt[]) throws Exception{
        StringBuilder sb=new StringBuilder();
        for(byte b:bt){
            sb.append(String.format("%02X",b));
        }
        return sb.toString();
    }
}
