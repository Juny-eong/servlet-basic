package algorithm.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052 {

    static String[] numberArray;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int N = Integer.parseInt(br.readLine());
            numberArray = new String[N];

            for (int j = 0; j < N; j++) {
                numberArray[j] = br.readLine();
            }
            Arrays.sort(numberArray);

            check();

        }

    }

    static void check() {
        for (int k = 0; k < numberArray.length - 1; k++) {
            if (numberArray[k + 1].indexOf(numberArray[k]) == 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
