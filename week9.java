import java.util.*;

class DiffieHellman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1 - Public values
        System.out.println("Enter modulo (p):");
        int p = sc.nextInt();

        System.out.println("Enter primitive root of " + p + ":");
        int g = sc.nextInt();

        // Step 2 - Private secrets
        System.out.println("Enter 1st secret number (Alice):");
        int a = sc.nextInt();

        System.out.println("Enter 2nd secret number (Bob):");
        int b = sc.nextInt();

        // Step 3 - Compute public keys
        int A = (int) Math.pow(g, a) % p;   // Alice's public key
        int B = (int) Math.pow(g, b) % p;   // Bob's public key

        // Step 4 - Compute shared secrets
        int S_A = (int) Math.pow(B, a) % p;  // Alice computes
        int S_B = (int) Math.pow(A, b) % p;  // Bob computes

        // Step 5 - Check if same
        if (S_A == S_B) {
            System.out.println("Both can communicate!");
            System.out.println("Shared secret = " + S_A);
        } else {
            System.out.println("Cannot communicate!");
        }

        sc.close();
    }
}