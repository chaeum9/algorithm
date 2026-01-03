import java.io.*;
import java.util.*;

public class Main {
    static int chess[][];
    static int move[][] = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2},
                            {2, 1}, {1, 2}, {2, -1}, {1, -2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            int l = Integer.parseInt(br.readLine());
            chess = new int[l+1][l+1];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            sb.append(bfs(startX, startY, endX, endY, l)).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int startX, int startY, int endX, int endY, int l) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startX, startY));
        chess[startX][startY] = -1;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if(x == endX && y == endY) {
                return chess[x][y] + 1;
            }

            for(int i = 0; i < move.length; i++) {
                int nx = move[i][0] + x, ny = move[i][1] + y;
                if((nx >= 0 && ny >= 0) && (nx < l && ny < l) && chess[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    chess[nx][ny] = chess[x][y] + 1;
                }
            }
        }
        return -1;
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
