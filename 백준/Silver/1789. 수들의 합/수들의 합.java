import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long currSum = 0, count = 0;

        for(long i = 1; i <= s; i++) {
            if((currSum + i) > s) {
                break;
            } else {
                currSum += i;
                count++;
            }
        }
        System.out.print(count);
    }
}