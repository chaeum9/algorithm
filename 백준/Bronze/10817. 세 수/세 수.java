import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] numArr= new int[3];

        numArr[0] = Integer.parseInt(str.split(" ")[0]);
        numArr[1] = Integer.parseInt(str.split(" ")[1]);
        numArr[2] = Integer.parseInt(str.split(" ")[2]);

        Arrays.sort(numArr);

        System.out.print(numArr[1]);
    }
}