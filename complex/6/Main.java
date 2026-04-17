// package complex.5;
import java.util.*;
public class Main {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the modulo:");
        int p=sc.nextInt();

        System.out.println("enter the primitive root:");
        int g=sc.nextInt();

        System.out.println("enter the first number:");
        int a=sc.nextInt();
        System.out.println("enter the second number:");
        int b=sc.nextInt();
        int A=(int)Math.pow(g,a);
        int B=(int)Math.pow(g,b);

        int S_A=(int)Math.pow(B,a);
        int S_B=(int)Math.pow(A,b);
        if(S_A==S_B){
            System.out.println("both persons can communicate");
        }
        else{
            System.out.println("they  can not communicate");
        }


    }
}
