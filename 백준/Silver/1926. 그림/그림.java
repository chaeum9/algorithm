import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int drawingCnt = 0;
        int drawingMaxArea = 0;

        // 전체를 순회하며 그림(1)이면서 방문하지 않은 곳을 찾음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    drawingCnt++;
                    // BFS를 통해 해당 그림의 넓이를 구하고 최댓값 갱신
                    drawingMaxArea = Math.max(drawingMaxArea, bfs(i, j));
                }
            }
        }

        System.out.println(drawingCnt);
        System.out.print(drawingMaxArea);
    }

    static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;
        int area = 1;

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = dx[i] + point.x;
                int nextY = dy[i] + point.y;

                if((0 <= nextX && nextX < n) && (0 <= nextY && nextY < m)
                        && !visited[nextX][nextY] && paper[nextX][nextY] == 1) {
                    queue.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    area++;
                }
            }
        }

        return area;
    }
}