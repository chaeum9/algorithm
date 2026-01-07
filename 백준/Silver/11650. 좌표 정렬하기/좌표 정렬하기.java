import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] coordinate = new int[n][2];

        for(int i = 0; i < coordinate.length; i++) {
            String str = br.readLine();
            coordinate[i][0] = Integer.parseInt(str.split(" ")[0]);
            coordinate[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(coordinate, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        for(int i = 0; i < coordinate.length; i++) {
            sb.append(coordinate[i][0]).append(' ').append(coordinate[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}