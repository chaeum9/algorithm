import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean [][] list;
    static boolean [] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        n = Integer.parseInt(st.nextToken()); // 정점 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수
        list = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u][v] = true;
            list[v][u] = true;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.print(count);
    }

    private static boolean DFS(int node) {
        if(visited[node])
            return false;
        visited[node] = true;

        for(int i = 1; i <= n; i++) {
            if(list[node][i]) {
                DFS(i);
            }
        }

        return true;
    }
}