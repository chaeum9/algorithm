import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] serialNums = new String[n];
        for(int i = 0; i < serialNums.length; i++) {
            serialNums[i] = br.readLine();
        }

        Arrays.sort(serialNums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    if(compareInStrNums(s1) == compareInStrNums(s2)) {
                        return s1.compareTo(s2); // 여길 어떻게?
                    }
                    return compareInStrNums(s1) - compareInStrNums(s2);
                }
                return s1.length() - s2.length();
            }
        });

        for(int i = 0; i < serialNums.length; i++) {
            System.out.println(serialNums[i]);
        }
    }

    static int compareInStrNums(String str) {
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return sum;
    }
}