import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n개의 물건
        int k = Integer.parseInt(st.nextToken()); // 최대 무게 k

        int[] dp = new int[k+1];
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 물건의 무게 w
            int v = Integer.parseInt(st.nextToken()); // 물건의 가치 v

            for(int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }

        System.out.print(dp[k]);
    }
}