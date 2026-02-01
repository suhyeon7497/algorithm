import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
    int r, c, dir;
    public Robot(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}

public class P14503 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            if (board[robot.r][robot.c] == 0) {
                board[robot.r][robot.c] = -1;
                answer++;
                continue;
            }
            boolean isAroundClear = true;
            for (int i = 0; i < 4; i++) {
                int ny = robot.r + dy[i];
                int nx = robot.c + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (board[ny][nx] == 0) isAroundClear = false;
            }

            if (isAroundClear) {
                int ny = robot.r + dy[(robot.dir + 2) % 4];
                int nx = robot.c + dx[(robot.dir + 2) % 4];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;
                if (board[ny][nx] == 1) break;
                robot.r = ny;
                robot.c = nx;
            }
            else {
                while (true) {
                    robot.dir = robot.dir - 1 == -1 ? 3 : robot.dir - 1;
                    int ny = robot.r + dy[robot.dir];
                    int nx = robot.c + dx[robot.dir];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (board[ny][nx] == 0) {
                        robot.r = ny;
                        robot.c = nx;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
