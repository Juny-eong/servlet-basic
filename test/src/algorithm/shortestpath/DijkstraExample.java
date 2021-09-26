package algorithm.shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraExample {

    static final int INF = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static ArrayList<Node>[] graph;
    static int[] costTable;
    static int N;
    static int M;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // node
        M = Integer.parseInt(st.nextToken()); // edge
        start = Integer.parseInt(br.readLine()); // start node

        isVisited = new boolean[N + 1]; // visit-log of each node
        graph = new ArrayList[N + 1]; // node array
        costTable = new int[N + 1]; // lowest cost to visit each node
        Arrays.fill(costTable, INF);

        /* initialize graph */
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[startNode].add(new Node(endNode, cost));
        }

        dijkstra(start);

        for (int i = 0; i < N + 1; i++) {
            if (costTable[i] == INF) {
                System.out.println(-1);
            }
            else {
                System.out.println(costTable[i]);
            }
            
        }

    }

    static int getLowestCostNode() {
        int temp = INF;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (costTable[i] < temp && !isVisited[i]) {
                temp = costTable[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start) {

        /* 1. set start & visit check */
        costTable[start] = 0;
        isVisited[start] = true;

        /*  */
        for (int i = 0; i < graph[start].size(); i++) {
            Node tmp = graph[start].get(i);
            costTable[tmp.index] = tmp.cost;
        }

        for (int i = 0; i < N - 1; i++) {
            int now = getLowestCostNode();
            isVisited[now] = true;

            for (int j = 0; j < graph[now].size(); j++) {
                Node tempNode = graph[now].get(j);

                int node = tempNode.index;
                int cost = costTable[now] + tempNode.cost;

                if (cost < costTable[node]) {
                    costTable[node] = cost;
                }
            }
        }
    }

    /* Node Class */
    static class Node {
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

}
