// package complex.2;
import java.util.*;
public class Main {
    static String a="abcdefghijklmnopqrstuvwxyz";
    static String b="zyxwvutsrqponmlkjihgfedcba";
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the text:");
        String text=sc.nextLine();

        String enc=encrypt(text);
        String dec=decrypt(enc);
        System.out.println("encrypted text:"+enc);
        System.out.println("decrypted text:"+dec);

    }
    private static String encrypt(String text){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            int ind=a.indexOf(ch);
            if(ind!=-1){
                sb.append(b.charAt(ind));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    private static String decrypt(String text){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            int ind=b.indexOf(ch);
            if(ind!=-1){
                sb.append(a.charAt(ind));
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
