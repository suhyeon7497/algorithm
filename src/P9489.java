import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P9489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] arg = input.split(" ");
            int n = Integer.parseInt(arg[0]);
            int k = Integer.parseInt(arg[1]);

            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] tree = new int[n][2];
            for (int i = 0; i < n; i++) {
                tree[i][0] = nums[i];
                tree[i][1] = -1;
            }
            int pIdx = 0;
            int kIdx = 0;
            int prev = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] == k) kIdx = i;
                if (prev + 1 != nums[i] && i > 1) pIdx++;
                if (i != 0) tree[i][1] = pIdx;
                else tree[i][1] = -1;
                prev = nums[i];
            }

            int answer = 0;
            int parentNode = tree[kIdx][1];

            for (int i = 1; i < n; i++) {
                int curParent = tree[i][1];
                if (tree[parentNode][1] == tree[curParent][1] && parentNode != curParent) answer++;
            }

            bw.write(answer + "\n");
            bw.flush();
        }
    }
}
