import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zeroChunk = 0, oneChunk = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (s.charAt(i - 1) == '0') zeroChunk++;
                else oneChunk++;
            }
        }

        if (s.charAt(s.length() - 1) == '0') zeroChunk++;
        else oneChunk++;

        System.out.print(Math.min(zeroChunk, oneChunk));
    }
}