package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5658_보물상자_비밀번호_박명규 {
    static int N, K, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            String line = br.readLine();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N / 4; i++) {
                int start = 0;
                int end = N / 4;
                for (int j = 0; j < 4; j++) {
                    String hex = line.substring(start, end);
                    int num = Integer.parseInt(hex, 16);
                    if (!list.contains(num)) list.add(num);
                    start = end;
                    end += N / 4;
                }
                char c = line.charAt(N - 1);
                line = c + line.substring(0, N - 1);


            }
            list.sort(Comparator.reverseOrder());
                sb.append("#").append(tc).append(" ").append(list.get(K - 1)).append("\n");
        }
        System.out.print(sb);
    }
}
