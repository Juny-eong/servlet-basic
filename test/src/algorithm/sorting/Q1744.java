package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1744 {

    /**
     * 1 * 0
     * 0 * -1
     * 1 * -1
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] newArr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        /* 음수 */
        for (int i = 0; i < N && arr[i] < 0; i += 2) {
            if (i + 1 < N && arr[i + 1] <= 0) {
                answer += arr[i] * arr[i + 1];
            }
            else {
                // (음수,0) 이거나 (음수)
                answer += arr[i];
                break;
            }
        }

        /* 양수 */
        int i = 0;
        for (i = N - 1; i >= 0 && arr[i] > 1; i -= 2) {
            if (i > 0 && arr[i - 1] > 1) {
                answer += arr[i] * arr[i - 1];
            }
            else {
                break;
            }
        }

        while (i >= 0 && arr[i] > 0) {
            answer += arr[i];
            i--;
        }
        System.out.println(answer);



    }
}
