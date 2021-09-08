package algorithm.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E805_monetary_composition {

     static int N;
     static int M;
     static int[] arr;
     static int dp[] = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int money : arr) {
            for (int i = money; i <= M; i++) {
                dp[i] = Math.min(dp[i], dp[i - money] + 1);
                System.out.printf("dp[%d] = %d", i, dp[i]);
                System.out.println();
            }
        }
        if (dp[M] == 10001) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[M]);
        }

    }
}
