import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a + b;
            sb.append("Case #").append(i).append(": ")
                    .append(a).append(" + ").append(b).append(" = ").append(c)
                    .append("\n");
        }
        System.out.print(sb);
    }
}