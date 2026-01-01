import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++) {
            String answer = "";
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String[] p = st.nextToken().split("");

            for(int i = 0; i < p.length; i++) {
                for(int j = 0; j < r; j++) {
                    answer += p[i];
                }
            }
            System.out.println(answer);
        }
    }
}