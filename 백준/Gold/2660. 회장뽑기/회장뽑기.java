import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 51;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mmbCnt = Integer.parseInt(br.readLine());
        dist = new int[mmbCnt + 1][mmbCnt + 1];

        for (int i = 1; i <= mmbCnt; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;

            dist[a][b] = dist[b][a] = 1;
        }

        for (int k = 1; k <= mmbCnt; k++) {
            for (int i = 1; i <= mmbCnt; i++) {
                for (int j = 1; j <= mmbCnt; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        List<Integer>[] scoreList = new List[mmbCnt+1];
        for (int i = 0; i <= mmbCnt; i++) {
            scoreList[i] = new ArrayList<>();
        }
        for (int i = 1; i <= mmbCnt; i++) {
            int maxScore = -1;
            for (int j = 1; j <= mmbCnt; j++) {
                maxScore = Math.max(maxScore, dist[i][j]);
            }
            scoreList[maxScore].add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= mmbCnt; i++) {
            if (!scoreList[i].isEmpty()) {
                sb.append(i).append(' ').append(scoreList[i].size()).append('\n');
                for (Integer member : scoreList[i]) {
                    sb.append(member).append(' ');
                }
                break;
            }
        }
        System.out.print(sb);
    }
}
