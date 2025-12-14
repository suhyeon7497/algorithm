import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12919 {

    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();

        bt(s, t);

        System.out.println(answer ? 1 : 0);
    }

    private static void bt(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                answer = true;
            }
            return;
        }

        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t.substring(1));
            sb.reverse();
            bt(s, sb.toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            bt(s, t.substring(0, t.length() - 1));
        }

    }
}
