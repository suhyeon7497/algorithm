import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Integer> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            houses.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(houses);

        // 간격 별로 설치해보기
        int ans = 0;
        int l = 0, r = houses.get(n - 1);
        while (l <= r) {
            int mid = (r + l) / 2;
            if (canInstall(mid, c, houses)) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean canInstall(int mid, int c, ArrayList<Integer> houses) {
        int prev = houses.get(0);
        c--;
        for (int i = 1; i < houses.size(); i++) {
            if (prev + mid <= houses.get(i)) {
                c--;
                prev = houses.get(i);
            }
        }
        if (c <= 0) {
            return true;
        }
        return false;
    }
}
