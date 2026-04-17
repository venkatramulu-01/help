import java.util.*;

public class Main {

    // Modular inverse
    static int modInv(int a) {
        for (int i = 1; i < 26; i++)
            if ((a * i) % 26 == 1)
                return i;
        return -1;
    }

    // Determinant of 3x3
    static int det(int[][] k) {
        int d = k[0][0]*(k[1][1]*k[2][2]-k[1][2]*k[2][1])
              - k[0][1]*(k[1][0]*k[2][2]-k[1][2]*k[2][0])
              + k[0][2]*(k[1][0]*k[2][1]-k[1][1]*k[2][0]);

        return (d % 26 + 26) % 26;
    }

    // Inverse matrix
    static int[][] inverse(int[][] k) {
        int d = det(k);
        int invDet = modInv(d);
        if (invDet == -1) return null;

        int[][] inv = new int[3][3];

        inv[0][0] =  (k[1][1]*k[2][2] - k[1][2]*k[2][1]);
        inv[0][1] = -(k[0][1]*k[2][2] - k[0][2]*k[2][1]);
        inv[0][2] =  (k[0][1]*k[1][2] - k[0][2]*k[1][1]);

        inv[1][0] = -(k[1][0]*k[2][2] - k[1][2]*k[2][0]);
        inv[1][1] =  (k[0][0]*k[2][2] - k[0][2]*k[2][0]);
        inv[1][2] = -(k[0][0]*k[1][2] - k[0][2]*k[1][0]);

        inv[2][0] =  (k[1][0]*k[2][1] - k[1][1]*k[2][0]);
        inv[2][1] = -(k[0][0]*k[2][1] - k[0][1]*k[2][0]);
        inv[2][2] =  (k[0][0]*k[1][1] - k[0][1]*k[1][0]);

        // Apply mod and multiply by inverse determinant
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inv[i][j] = ((inv[i][j] % 26 + 26) % 26 * invDet) % 26;

        return inv;
    }

    // Encrypt/Decrypt (same logic)
    static String process(String text, int[][] key) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        while (text.length() % 3 != 0)
            text += "X";

        String res = "";

        for (int i = 0; i < text.length(); i += 3) {
            int[] v = new int[3];

            for (int j = 0; j < 3; j++)
                v[j] = text.charAt(i + j) - 'A';

            for (int r = 0; r < 3; r++) {
                int sum = 0;
                for (int c = 0; c < 3; c++)
                    sum += key[r][c] * v[c];

                res += (char)((sum % 26) + 'A');
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] key = new int[3][3];

        System.out.println("Enter key matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String enc = process(text, key);
        System.out.println("Encrypted: " + enc);

        int[][] inv = inverse(key);
        if (inv == null) {
            System.out.println("Key not invertible!");
            return;
        }

        String dec = process(enc, inv);
        System.out.println("Decrypted: " + dec);
    }
}