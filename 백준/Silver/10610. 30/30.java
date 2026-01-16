import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int sum = 0;
        char[] numArr = str.toCharArray();
        Arrays.sort(numArr);
        int len = numArr.length;

        for(int i = len - 1; i >= 0; i--) {
            int num = numArr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if(numArr[0] != '0' || sum % 3 != 0) {
            System.out.print(-1);
            return;
        }

        System.out.print(sb.toString());
    }
}