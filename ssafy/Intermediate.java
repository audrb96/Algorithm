package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Intermediate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int testCase = 1;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            char[][] area = new char[N][N];
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < N; i++) {
                area[i] = br.readLine().toCharArray();
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    switch (area[r][c]) {
                        case 'A':
                            for (int i = 0; i < 4; i++) {
                                int nx = c + dx[i];
                                int ny = r + dy[i];
                                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                    if (area[ny][nx] == 'H')
                                        area[ny][nx] = 'X';
                                }
                            }
                            break;
                        case 'B':
                            for (int i = 1; i < 3; i++) {
                                for (int j = 0; j < 4; j++) {
                                    int nx = c + dx[j] * i;
                                    int ny = r + dy[j] * i;
                                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                        if (area[ny][nx] == 'H')
                                            area[ny][nx] = 'X';
                                    }
                                }
                            }
                            break;
                        case 'C':
                            for (int i = 1; i < 4; i++) {
                                for (int j = 0; j < 4; j++) {
                                    int nx = c + dx[j] * i;
                                    int ny = r + dy[j] * i;
                                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                        if (area[ny][nx] == 'H')
                                            area[ny][nx] = 'X';
                                    }
                                }
                            }
                        default:
                            break;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] == 'H')
                        ans++;
                }
            }
            System.out.println("#" + testCase++ + " " + ans);
        }
    }
}