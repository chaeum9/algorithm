import java.util.*;
import java.io.*;

public class Main {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 그래프 선언 및 초기화 과정
        int n = Integer.parseInt(st.nextToken());   // 도시의 개수
        int m = Integer.parseInt(st.nextToken());   // 도로의 개수
        int k = Integer.parseInt(st.nextToken());   // 거리 정보
        int x = Integer.parseInt(st.nextToken());   // 출발 도시의 정보

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        // 거리 배열 초기화 (-1은 방문하지 않음)
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        // 시작 거리 방문
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        dist[x] = 0;


        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 다음 행선지 추적
            for(int next : graph.get(now)) {
                if(dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for(int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if(!found) {
            System.out.println("-1");
        } else {
            System.out.print(sb.toString());
        }
    }
}