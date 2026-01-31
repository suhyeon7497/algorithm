import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        int[] value = new int[n];

        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (j >= weight[i]) {
                    int prev = (i > 0) ? dp[i - 1][j - weight[i]] : 0;
                    dp[i][j] = Math.max(dp[i][j], prev + value[i]);
                }
            }
        }
        System.out.println(dp[n - 1][k]);
    }
}
