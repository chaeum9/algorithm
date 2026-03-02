import java.util.*;
import java.io.*;

class Move {
    int pos;
    int time;

    Move(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

    Move() {

    }
}

public class Main {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 수빈 위치
        k = Integer.parseInt(st.nextToken());   // 동생 위치

        System.out.print(bfs(n));
    }

    static int bfs(int start) {
        Deque<Move> deque = new ArrayDeque<>();
        deque.add(new Move(start, 0));

        while(!deque.isEmpty()) {
            Move curr = deque.poll();
            int x = curr.pos;
            int time = curr.time;
            visited[x] = true;

            if(x == k) {
                return time;
            }

            // 1. 순간이동: 0초 소요 (우선순위 높음 -> addFirst)
            if (x * 2 <= 100000 && !visited[x * 2]) {
                deque.addFirst(new Move(x * 2, time));
            }

            // 2. 걷기: 1초 소요 (우선순위 낮음 -> addLast)
            if (x - 1 >= 0 && !visited[x - 1]) {
                deque.addLast(new Move(x - 1, time + 1));
            }
            if (x + 1 <= 100000 && !visited[x + 1]) {
                deque.addLast(new Move(x + 1, time + 1));
            }

        }
        return -1;
    }
}