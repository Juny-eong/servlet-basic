package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1916_low_cost {

    static final int INF = 987_654_321;
    static int N;
    static int M;
    static int startNode;
    static int targetNode;
    static ArrayList<ConnectionInfo>[] graph;
    static int[] costTable;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // city
        M = Integer.parseInt(br.readLine()); // bus

        /* initialize graph */
        graph = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        costTable = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(costTable, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(  new ConnectionInfo(target, cost)  );
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        targetNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);

        if (startNode == targetNode) {
            System.out.println(0);
        }
        else {

            System.out.println(costTable[targetNode]);
        }



    }

    static void dijkstra(int start) {

        isVisited[start] = true;
        costTable[start] = 0;

        /* update costTable with startNode */
        for (int i = 0; i < graph[start].size(); i++) {
            ConnectionInfo connectionInfo = graph[start].get(i);
            costTable[connectionInfo.index] = connectionInfo.cost;
        }

        /* nodeCount - 1 (= N - 1) */
        for (int i = 0; i < N - 1; i++) {

            int current = getLowestCostNode();
            isVisited[current] = true;

            /* update costTable with currentNode */
            for (int j = 0; j < graph[current].size(); j++) {
                ConnectionInfo connInfo = graph[current].get(j);
                int node = connInfo.index;

                /* cost[x] vs. cost[d][i] + cost[i][x] */
                costTable[node] = Math.min(costTable[current] + connInfo.cost, costTable[node]);
            }
        }
    }

    static int getLowestCostNode() {
        int tmp = INF;
        int index = 0;
        for (int i = 1; i < N + 1; i++) {
            if (costTable[i] < tmp && !isVisited[i]) {
                tmp = costTable[i];
                index = i;
            }
        }
        return index;
    }


    static class ConnectionInfo {
        private int index;
        private int cost;

        public ConnectionInfo(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

}
