import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] picked, inputArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picked = new int[m];
        inputArr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr);   // 사전순 + 중복 스킵을 위해 필수

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
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (inputArr[i] == prev) continue;

            visited[i] = true;
            picked[depth] = inputArr[i];
            prev = inputArr[i];

            dfs(depth + 1);

            visited[i] = false;
        }
    }
}