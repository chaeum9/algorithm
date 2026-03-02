import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int target;
    int distance;

    Edge(int target, int distance) {
        this.target = target;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return this.distance - other.distance;
    }
}

public class Main {
    static List<List<Edge>> graph = new ArrayList<>();
    static int n, e, u, v;
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 정점 개수
        e = Integer.parseInt(st.nextToken());   // 간선 개수

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while(e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // startNode
            int b = Integer.parseInt(st.nextToken());   // endNode
            int c = Integer.parseInt(st.nextToken());   // start ~ end distance

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        long path1 = 0;
        path1 += dijkstra(1, u);
        path1 += dijkstra(u, v);
        path1 += dijkstra(v, n);

        long path2 = 0;
        path2 += dijkstra(1, v);
        path2 += dijkstra(v, u);
        path2 += dijkstra(u, n);

        long result = Math.min(path1, path2);

        if(result >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.distance > dist[curr.target]) continue;

            for(Edge next : graph.get(curr.target)) {
                if(dist[next.target] > dist[curr.target] + next.distance) {
                    dist[next.target] = dist[curr.target] + next.distance;
                    pq.add(new Edge(next.target, dist[next.target]));
                }
            }
        }
        return dist[end];
    }
}