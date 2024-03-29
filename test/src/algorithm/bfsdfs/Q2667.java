package algorithm.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int setCount = 1;
    static List<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    answerList.add(bfs(i, j));
                    setCount++;
                }
            }
        }

        System.out.println(answerList.size());
        Collections.sort(answerList);
        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }

        System.out.println("------");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int bfs(int x, int y) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;
        map[x][y] = setCount;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            answer++;

            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];

                if (0 <= newX && newX < N && 0 <= newY && newY < N
                        && map[newX][newY] != 0
                        && !isVisited[newX][newY]) {
                    map[newX][newY] = setCount;
                    queue.offer(new int[] {newX, newY});
                    isVisited[newX][newY] = true;
                }
            }
        }
        return answer;
    }

}
