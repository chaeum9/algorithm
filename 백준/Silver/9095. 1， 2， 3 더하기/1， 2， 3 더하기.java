import java.io.*;
import java.util.Arrays;

public class Main {
    static int dp[] = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(topDown(n));
        }
    }

    static int topDown(int n) {
        if(dp[n] != -1) return dp[n];
        return dp[n] = topDown(n-1) + topDown(n-2) + topDown(n-3);
    }
}