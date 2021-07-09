package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5585 {

    static final int[] exchange = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int money = 1000 - Integer.parseInt(st.nextToken());
        
        int idx = 0;
        int ans = 0;

        while (money != 0) {

            int change = money / exchange[idx];
            money -= change * exchange[idx++];

            ans += change;
        }

        System.out.println(ans);

    }
    
}
