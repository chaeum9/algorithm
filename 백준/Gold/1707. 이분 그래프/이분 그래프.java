import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int color[];
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());
        int v, e;

        for(int test = 0; test < k; test++) {
            answer = "YES";
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for(int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            color = new int[v];

            for(int i = 0; i < v; i++) {
                if(color[i] == 0) {
                    if(!bfs(i)) {
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static boolean bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        color[n] = 1;
        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(Integer i : graph.get(node)) {
                if(color[node] == color[i]) {
                    answer = "NO";
                    return false;
                }
                if(color[i] == 0) {
                    color[i] = color[node] * -1;
                    queue.add(i);
                }
            }
        }
        return true;
    }
}