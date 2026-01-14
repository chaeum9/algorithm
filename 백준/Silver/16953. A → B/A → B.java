import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int a = Integer.parseInt(str.split(" ")[0]);
        int b = Integer.parseInt(str.split(" ")[1]);
        int count = 0;

        while(b > a) {
            if(b % 10 == 1) {
                b = (b - 1) / 10;
                count++;
            } else if (b % 2 == 0) {
                b /= 2;
                count++;
            } else {
                break;
            }
        }

        if(b == a)  count = count + 1;
        else        count = -1;
        System.out.print(count);
    }
}