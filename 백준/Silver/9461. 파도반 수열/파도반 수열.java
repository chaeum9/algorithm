import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = dp[1] + dp[3];
        dp[5] = dp[4];

        for(int i = 6; i <= 100; i++) {
            dp[i] = dp[i-5] + dp[i-1];
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}