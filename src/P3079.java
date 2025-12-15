import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        long l = 0, r = Long.MAX_VALUE / 3 * 2;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (canPass(mid, m, times)) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean canPass(long mid, long m, long[] times) {
        for (int i = 0; i < times.length; i++) {
            m -= mid / times[i];
            if (m <= 0) return true;
        }
        return false;
    }
}
