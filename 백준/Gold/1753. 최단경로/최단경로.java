import java.io.*;
import java.util.*;

class DirectedGraph {
    int startNode;
    int endNode;
    int weight;

    public DirectedGraph(int startNode, int endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }
}

public class Main {
    static List<List<DirectedGraph>> dirGraphList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수
        int k = Integer.parseInt(br.readLine());    // 시작 정점 번호
        int u, v, w;    // u에서 v로 가는 가중치 w

        for(int i = 0; i <= V; i++) {
            dirGraphList.add(new ArrayList<>());
        }

        while(E-- > 0) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            DirectedGraph dirGraph = new DirectedGraph(u, v, w);

            dirGraphList.get(u).add(dirGraph);
        }

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curWeight = cur[1];

            if(curWeight > dist[curNode])   continue;

            for(DirectedGraph next : dirGraphList.get(curNode)) {
                int nextNode = next.endNode;
                int weight = next.weight;

                if(dist[nextNode] > curWeight + weight) {
                    dist[nextNode] = curWeight + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        for(int i = 1; i < dist.length; i++) {
            if(dist[i] < INF) sb.append(dist[i]).append('\n');
            else        sb.append("INF").append('\n');
        }
        System.out.print(sb);
    }
}