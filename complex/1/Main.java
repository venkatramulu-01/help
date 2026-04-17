// package complex.1;
import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the text:");
        String text=sc.nextLine();
        System.out.println("enter the key:");
        int key=sc.nextInt();

        String enc=encrypt(text,key);
        String dec=decrypt(enc,key);
        System.out.println("encypted text:"+enc);
        System.out.println("decrypted text:"+dec);

    }
    private static String encrypt(String text,int key){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(Character.isUpperCase(ch)){
                ch=(char)(ch+(key%26));
                if(ch>'Z'){
                    ch-=26;
                }
            }
            else if(Character.isLowerCase(ch)){
                ch=(char)(ch+(key%26));
                if(ch>'z'){
                    ch-=26;
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    private static String decrypt(String text,int key){
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(Character.isUpperCase(ch)){
                ch=(char)(ch-(key%26));
                if(ch<'A'){
                    ch+=26;
                }
            }
            else if(Character.isLowerCase(ch)){
                ch=(char)(ch-(key%26));
                if(ch<='a'){
                    ch+=26;
                }
            }
            // return sb.toString();
            sb.append(ch);
        }
        return sb.toString();
    }
}
