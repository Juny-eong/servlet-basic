package algorithm.bfsdfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2146 {

    static boolean[][] isVisited;
    static int[][] map;
    static int[] point;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int landCount = 2;
    static int answer = 9999;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* create newMap */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    getLandNum(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    isVisited = new boolean[N][N];
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }


    static void getLandNum(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));
        isVisited[x][y] = true;
        map[x][y] = landCount;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = point.x + dx[i];
                int tempY = point.y + dy[i];

                if ((0 <= tempX && tempX < N && 0 <= tempY && tempY < N)
                        && !isVisited[tempX][tempY]
                        && map[tempX][tempY] == 1) {
                    isVisited[tempX][tempY] = true;
                    map[tempX][tempY] = landCount;
                    queue.offer(new Point(tempX, tempY, 0));
                }
            }
        }
        landCount++;
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));
        isVisited[x][y] = true;
        int currentLandNum = map[x][y];

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = point.x + dx[i];
                int tempY = point.y + dy[i];

                if ((0 <= tempX && tempX < N && 0 <= tempY && tempY < N)
                        && !isVisited[tempX][tempY]
                        && map[tempX][tempY] != currentLandNum) {
                    isVisited[tempX][tempY] = true;
                    if (map[tempX][tempY] == 0) {
                        queue.offer(new Point(tempX, tempY, point.value + 1));
                    }
                    else {
                        answer = Math.min(answer, point.value);
                    }
                }
            }

        }
    }

    public static class Point {
        int x;
        int y;
        int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

}
