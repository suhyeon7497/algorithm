import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < t; l++) {
            String line = br.readLine();
            sb.append(validatePalindrome(line, 0, line.length() - 1, 0) + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int validatePalindrome(String line, int left, int right, int check) {
        if (check >= 2) return 2;

        while (left < right) {
            if (line.charAt(left) == line.charAt(right)) {
                left++;
                right--;
            }
            else {
                return Math.min(validatePalindrome(line, left + 1, right, check + 1), validatePalindrome(line, left, right - 1, check + 1));
            }
        }

        return check;
    }
}
