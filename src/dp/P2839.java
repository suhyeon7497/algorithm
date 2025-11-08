package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sugar = Integer.parseInt(br.readLine());

        if (sugar == 4) {
            bw.write(String.valueOf(-1));
            bw.flush();
            return;
        }

        int[] dp = new int[sugar + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = dp[5] = 1;

        for (int i = 6; i <= sugar; i++) {
            if (dp[i - 3] == Integer.MAX_VALUE && dp[i - 5] == Integer.MAX_VALUE) continue;
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
        bw.write(String.valueOf(dp[sugar]));
        bw.flush();
    }
}
