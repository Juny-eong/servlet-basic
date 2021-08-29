package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q18870 {
    static int N;
    static int[] arr;
    static int idx = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedArr.length; i++) {
            if (!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (sb.length() == 0) {
                sb.append(map.get(arr[i]));
            } else
                sb.append(" " + map.get(arr[i]));
        }

        System.out.println(sb.toString());





    }

}
