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
    static int n, m, x;
    static List<List<Edge>> graph = new ArrayList<>();
    static List<List<Edge>> revGraph = new ArrayList<>();
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 학생 수
        m = Integer.parseInt(st.nextToken());   // 단방향 도로 개수
        x = Integer.parseInt(st.nextToken());   // 도착지점

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Edge(end, time));
            revGraph.get(end).add(new Edge(start, time));
        }

        int[] goParty = dijkstra(revGraph, x);
        int[] goHome = dijkstra(graph, x);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (goParty[i] != INF && goHome[i] != INF) {
                result = Math.max(result, goParty[i] + goHome[i]);
            }
        }
        System.out.print(result);
    }

    static int[] dijkstra(List<List<Edge>> graph, int start) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (curr.distance > dist[curr.target])  continue;

            for (Edge next : graph.get(curr.target)) {
                if(dist[next.target] > dist[curr.target] + next.distance) {
                    dist[next.target] = dist[curr.target] + next.distance;
                    pq.add(new Edge(next.target, dist[next.target]));
                }
            }
        }
        return dist;
    }
}