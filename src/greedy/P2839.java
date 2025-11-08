package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sugar = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(solve(sugar, 0)));
        bw.flush();
    }

    private static int solve(int sugar, int depth) {
        if (sugar == 0) {
            return depth;
        }

        if (sugar < 0) {
            return -1;
        }

        int pack = solve(sugar - 5, depth + 1);
        if (pack != -1) return pack;
        return solve(sugar - 3, depth + 1);
    }
}
