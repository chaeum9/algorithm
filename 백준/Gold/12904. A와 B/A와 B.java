import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length() < t.length()) {
            char last = t.charAt(t.length() - 1);
            if (last == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else if (last == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }
        System.out.print(t.toString().equals(s.toString()) ? 1 : 0);
    }
}