import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append("1 1\n");
                continue;
            }
            int[] alpha = new int[26];
            for (int j = 0; j < line.length(); j++) {
                alpha[line.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < line.length(); j++) {
                if (alpha[line.charAt(j) - 'a'] < k) continue;
                int count = 1;
                for (int l = j + 1; l < line.length(); l++) {
                    if (line.charAt(l) == line.charAt(j)) {
                        count++;
                    }
                    if (count == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
                sb.append(min + " " + max + "\n");
            }
            else {
                sb.append("-1\n");
            }
        }
        System.out.println(sb.toString());
    }
}
