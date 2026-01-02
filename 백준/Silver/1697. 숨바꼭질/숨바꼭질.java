import java.io.*;
import java.util.*;

public class Main {
    static int position[] = new int[100001];
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input.split(" ")[0]); // 수빈
        k = Integer.parseInt(input.split(" ")[1]); // 동생

        int result = bfs(n);
        System.out.println(result);
    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(node);
        position[node] = 1;
        int x = 0;
        while(!queue.isEmpty()) {
            x = queue.remove();

            if(x == k) {
                return position[x]-1;
            }
            if(2*x <= 100000 && position[2*x] == 0) {
                position[2*x] = position[x] + 1;
                queue.add(2*x);
            }
            if(x+1 <= 100000 && position[x+1] == 0) {
                position[x+1] = position[x] + 1;
                queue.add(x+1);
            }
            if(x-1 >= 0 && position[x-1] == 0) {
                position[x-1] = position[x] + 1;
                queue.add(x-1);
            }
        }
        return -1;
    }
}