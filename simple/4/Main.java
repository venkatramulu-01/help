// package simple.4;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;
public class Main {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the first prime number:");
        BigInteger p=sc.nextBigInteger();
        System.out.println("enter 2nd prime number:");
        BigInteger q=sc.nextBigInteger();

        BigInteger n=p.multiply(q);
        BigInteger phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger e=generateE(phi);
        BigInteger d=e.modInverse(phi);
        System.out.println("public key:("+e+","+n+")");
        System.out.println("private key:("+d+","+n+")");
    }
    private static BigInteger generateE(BigInteger phi){
        Random rand=new Random();
        BigInteger e;
        do{
            e=new BigInteger(phi.bitLength(),rand);
        }while(e.compareTo(BigInteger.ONE)<=0||e.compareTo(phi)>=0||!phi.gcd(e).equals(BigInteger.ONE));
        return e;
    }
}
