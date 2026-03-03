import java.util.*;
import java.io.*;

class NodeCost implements Comparable<NodeCost> {
    int x, y, cost;

    NodeCost(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(NodeCost o) {
        return this.cost - o.cost; // 비용 기준 오름차순 정렬
    }
}

public class Main {
    static int n, m;
    static int[][] maze;
    static int[][] dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.print(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        PriorityQueue<NodeCost> pq = new PriorityQueue<>();
        pq.offer(new NodeCost(startX, startY, 0));
        dist[startX][startY] = 0;

        while(!pq.isEmpty()) {
            NodeCost curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;

            if(x == n-1 && y == m-1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 더 적은 벽을 부수고 방문할 수 있는 경우 업데이트
                    if (dist[nx][ny] > dist[curr.x][curr.y] + maze[nx][ny]) {
                        dist[nx][ny] = dist[curr.x][curr.y] + maze[nx][ny];
                        pq.offer(new NodeCost(nx, ny, dist[nx][ny]));
                    }
                }
            }
        }
        return 0;
    }
}