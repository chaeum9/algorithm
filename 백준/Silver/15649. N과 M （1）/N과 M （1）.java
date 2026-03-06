import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picked = new int[m];
        visited = new boolean[n+1];
        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for (int val : picked) sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                picked[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}