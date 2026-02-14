import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picked = new int[n];

        dfs(1, 0);
        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        // n 까지의 수열, m 개
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(picked[i]);

                if(i < m - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i <= n; i++) {
            picked[depth] = i;
            dfs(i, depth + 1);
        }
    }
}