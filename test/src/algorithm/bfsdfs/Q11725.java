package algorithm.bfsdfs;

import java.io.*;
import java.util.*;

public class Q11725 {
    static int N;
    static ArrayList<Integer>[] map;
    static int[] parentNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        parentNode = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x].add(y);
            map[y].add(x);
        }

        dfs(1);

        for (int i = 2; i < parentNode.length; i++) {
            bw.write(parentNode[i] + "\n");
        }
        bw.flush();
        bw.close();

    }


    static void dfs(int x) {
        for (int child : map[x]) {
            if (parentNode[child] != 0) continue;
            parentNode[child] = x;
            dfs(child);
        }
    }
}
