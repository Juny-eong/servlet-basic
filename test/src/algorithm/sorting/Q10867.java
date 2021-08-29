package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10867 {

    static int[] arr = new int[2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[temp + 1000]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.print(i - 1000 + " ");
            }
        }
    }
}
