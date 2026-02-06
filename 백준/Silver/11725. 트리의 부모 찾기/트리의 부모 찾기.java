import java.util.*;
import java.io.*;

public class Main {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        dfs(1);

        for(int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int x) {
        visited[x] = true;

        for(int i : graph.get(x)) {
            if(!visited[i]) {
                dfs(i);
                parent[i] = x;
            }
        }
    }
}