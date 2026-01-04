import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[][];
    static int m, n, k;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static List<Integer> spaceSizeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int bx = Integer.parseInt(st.nextToken()), by = Integer.parseInt(st.nextToken()),
                tx = Integer.parseInt(st.nextToken()), ty = Integer.parseInt(st.nextToken());

            for(int x = bx; x < tx; x++) {
                for(int y = by; y < ty; y++) {
                    visited[x][y] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j])
                    bfs(i, j);
            }
        }

        Collections.sort(spaceSizeList);
        sb.append(spaceSizeList.size()).append("\n");
        for(Integer spaceSize : spaceSizeList) {
            sb.append(spaceSize).append(" ");
        }

        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;
        int spaceSize = 1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int a = 0; a < 4; a++) {
                int nx = p.x + dx[a], ny = p.y + dy[a];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;

                    queue.add(new Point(nx, ny));
                    spaceSize++;
                }
            }
        }
        spaceSizeList.add(spaceSize);
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
