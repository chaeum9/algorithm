import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] picked, inputs;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picked = new int[m];
        inputs = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(picked[i]);
                if(i < m - 1)  sb.append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            picked[depth] = inputs[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}