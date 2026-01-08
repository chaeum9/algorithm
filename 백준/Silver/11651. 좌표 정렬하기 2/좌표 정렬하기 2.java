import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[][] numArr = new int[n][2];

        for(int i = 0; i < n; i++) {
            String[] dots = br.readLine().split(" ");
            numArr[i][0] = Integer.parseInt(dots[0]);
            numArr[i][1] = Integer.parseInt(dots[1]);
        }

        Arrays.sort(numArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        for(int i = 0; i < numArr.length; i++) {
            sb.append(numArr[i][0]).append(" ").append(numArr[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}