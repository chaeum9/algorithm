import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int result = 0;
        for(int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        
        System.out.print(result);
    }
}