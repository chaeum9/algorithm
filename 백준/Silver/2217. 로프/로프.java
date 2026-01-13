import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            int rope = Integer.parseInt(br.readLine());
            ropes[i] = rope;
        }
        Arrays.sort(ropes);

        for(int i = 0; i < n; i++) {
            count = Math.max(count, ropes[i] * (n-i));
        }

        System.out.print(count);
    }
}