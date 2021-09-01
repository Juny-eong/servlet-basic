package algorithm.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697_hide_and_seek {

    static int current;
    static int target;
    static int ans = Integer.MAX_VALUE;
    static boolean[] isVisited = new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        current = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        if (current == target) {
            System.out.println(0);
            return;
        }

        bfs(current);

        System.out.println(ans);
    }

    static void bfs(int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, 0));
        isVisited[x] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 3; i++) {
                int temp = point.position;
                if (i == 0)         temp += 1;
                else if (i == 1)    temp -= 1;
                else                temp *= 2;

                if (0 <= temp && temp <= 100000 && !isVisited[temp]) {
                    isVisited[temp] = true;
                    if (temp == target) {
                        ans = Math.min(ans, point.count + 1);
                    }
                    else {
                        queue.offer(new Point(temp, point.count + 1));
                    }
                }
            }
        }
    }

    static class Point {
        int position;
        int count;

        public Point(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }
}
