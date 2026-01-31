import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(n / 2, m / 2);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < min; j++) {
                rotate(j, j, n - j - 1, m - j - 1, board);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int y1, int x1, int y2, int x2, int[][] board) {
        int temp2;
        int temp1 = board[y1][x2];
        for (int i = x2 - 1; i >= x1; i--) {
            temp2 = board[y1][i];
            board[y1][i] = temp1;
            temp1 = temp2;
        }

        for (int i = y1 + 1; i <= y2; i++) {
            temp2 = board[i][x1];
            board[i][x1] = temp1;
            temp1 = temp2;
        }

        for (int i = x1 + 1; i <= x2; i++) {
            temp2 = board[y2][i];
            board[y2][i] = temp1;
            temp1 = temp2;
        }

        for (int i = y2 - 1; i >= y1; i--) {
            temp2 = board[i][x2];
            board[i][x2] = temp1;
            temp1 = temp2;
        }
    }
}
