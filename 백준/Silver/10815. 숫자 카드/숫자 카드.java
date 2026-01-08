import java.io.*;
import java.util.*;

public class Main {
    static int[] nCardArr;
    static int[] mCardArr;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nCardArr = new int[n];
        for(int i = 0; i < nCardArr.length; i++) {
            nCardArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nCardArr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        mCardArr = new int[m];
        for(int i = 0; i < mCardArr.length; i++) {
            mCardArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < mCardArr.length; i++) {
            sb.append(compareCard(mCardArr[i], 0 , nCardArr.length-1)).append(" ");
        }
        System.out.print(sb);

    }

    static int compareCard(int target, int left, int right) {
        int mid;

        if(left <= right) {
            mid = (left + right) / 2;

            if(target == nCardArr[mid]) {
                return 1;
            }
            if(target > nCardArr[mid]) {
                return compareCard(target, mid + 1, right);
            }
            if(target < nCardArr[mid]) {
                return compareCard(target, left, mid - 1);
            }
        }
        return 0;
    }
}