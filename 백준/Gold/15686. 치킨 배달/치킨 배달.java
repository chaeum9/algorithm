import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) houses.add(new int[]{i, j});
                if(temp == 2) chickens.add(new int[]{i, j});
            }
        }

        visited = new boolean[chickens.size()];
        backTracking(0, 0);
        System.out.print(result);
    }

    static void backTracking(int start, int depth) {
        if(depth == m) {
            int sum = 0;
            for(int[] house : houses) {
                int min = Integer.MAX_VALUE;
                for(int i = 0; i < chickens.size(); i++) {
                    if(visited[i]) {
                        int dist = Math.abs(house[0] - chickens.get(i)[0]) +
                                    Math.abs(house[1] - chickens.get(i)[1]);
                        min = Math.min(min, dist);
                    }
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for(int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            backTracking(i+1, depth+1);
            visited[i] = false;
        }
    }
}