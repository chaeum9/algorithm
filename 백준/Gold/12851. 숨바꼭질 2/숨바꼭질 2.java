import java.util.*;
import java.io.*;

class Node{
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}

public class Main {
    static int n, k;
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs();
        System.out.print(minTime + "\n" + count);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        Arrays.fill(time, Integer.MAX_VALUE);

        queue.add(new Node(n, 0));
        time[n] = 0;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int currTime = curr.distance;

            if (minTime < currTime)    continue;

            if (curr.index == k) {
                if (currTime < minTime) {
                    minTime = currTime;
                    count = 1;
                } else if (currTime == minTime) {
                    count++;
                }
                continue;
            }

            int[] nextPositions = {curr.index-1, curr.index+1, curr.index*2};

            for(int next : nextPositions) {
                if (next < 0 || next > 100000)  continue;

                if (time[next] >= currTime + 1) {
                    time[next] = currTime + 1;
                    queue.add(new Node(next, currTime + 1));
                }
            }
        }
    }
}