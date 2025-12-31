import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int dp[][] = new int[2][n+1];
            int cost[][] = new int[2][n+1];

            for(int i = 0; i < cost.length; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < cost[i].length-1; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];

            for(int i = 0; i < dp.length; i++) {
                for(int j = 1; j < dp[i].length; j++) {
                    if(j == 1) {
                        dp[0][1] = dp[1][0] + cost[0][1];
                        dp[1][1] = dp[0][0] + cost[1][1];
                        continue;
                    }
                    dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + cost[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + cost[1][j];
                }
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.print(sb);
    }
}