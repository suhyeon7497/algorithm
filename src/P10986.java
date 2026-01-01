import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num;
        int[] ipsum = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            if (i == 0) ipsum[i] = num % m;
            else ipsum[i] = (ipsum[i-1] + num) % m;
            if (ipsum[i] == 0) answer++;
            answer += map.getOrDefault(ipsum[i], 0);
            map.put(ipsum[i], map.getOrDefault(ipsum[i], 0) + 1);
        }

        System.out.println(answer);
    }
}
