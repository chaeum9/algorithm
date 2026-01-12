import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;

    static int n, m;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = -1;
                if (map[i][j] == 0) distance[i][j] = 0;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(distance[i][j]).append(' ');
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(j, i));
        visited[i][j] = true;
        distance[i][j] = 0;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int cr = point.y, cc = point.x;

            for(int a = 0; a < 4; a++) {
                int nr = dr[a] + cr;
                int nc = dc[a] + cc;

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] != 1) continue;
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                distance[nr][nc] = distance[cr][cc] + 1;
                queue.offer(new Point(nc, nr));
            }
        }
    }  
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x; // col
        this.y = y; // row
    }
}
