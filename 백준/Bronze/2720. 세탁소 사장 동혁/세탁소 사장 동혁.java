import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[] money = {25, 10, 5, 1};

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int idx = 0;

            while(idx < money.length) {
                int count = c / money[idx];
                c = c % money[idx];
                sb.append(count).append(' ');
                idx++;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}