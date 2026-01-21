import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n]; // 단어 저장
        int[] weight = new int[26];

        for(int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            int len = word.length(); // 알파벳의 가중치 구함
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                weight[c - 'A'] += Math.pow(10, len - 1 - i);
            }
        }

        Arrays.sort(weight);
        int num = 9;
        int result = 0;

        for(int i = 25; i >= 0; i--) {
            if (weight[i] == 0) break;
            result += weight[i] * num--;
        }

        System.out.print(result);
    }
}