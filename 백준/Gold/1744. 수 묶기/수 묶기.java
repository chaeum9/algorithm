import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1) plus.add(num);
            else if(num == 1) ones++;
            else if(num == 0) zeros++;
            else minus.add(num);
        }

        int result = 0;

        // 양수 처리
        plus.sort(Collections.reverseOrder());
        for(int i = 0; i < plus.size(); i+=2) {
            if(i+1 < plus.size()) {
                result += plus.get(i) * plus.get(i+1);
            } else {
                result += plus.get(i);
            }
        }

        // 1 처리
        result += ones;

        // 음수 처리
        Collections.sort(minus);
        for(int i = 0; i < minus.size(); i+=2) {
            // 0은 따로 계산하지 않고, 대상 음수를 제거하는 용도
            if(i+1 < minus.size()) {
                result += minus.get(i) * minus.get(i+1);
            } else {
                if(zeros == 0) result += minus.get(i);
            }
        }
        System.out.print(result);
    }
}