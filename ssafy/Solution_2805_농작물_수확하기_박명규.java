package ssafy;

import java.util.Scanner;

public class Solution_2805_농작물_수확하기_박명규 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testCase = 1;
        while (T-- > 0) {
            int N = sc.nextInt();
            sc.nextLine();
            int sum = 0;
            int[][] crops = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    crops[i][j] = line.charAt(j) - '0'; //농장 정보 입력받기
                }
            }
            //맨 처음줄 1개와 맨 마지막줄 1개 를 더한다.
            sum += crops[0][N / 2];
            sum += crops[N - 1][N / 2];
            //두번째 줄부터 가운데 줄까지 Sum에 더한다.
            for (int i = 1; i < N / 2 + 1; i++) {
                for (int j = N / 2 - i; j < N / 2 + i + 1; j++)
                    sum += crops[i][j];
            }

            int count = 1;
            if (N > 3)
                //농작크기가 3보다 크면 중간 다음부터 마지막 이전까지를 더한다.
                for (int i = N / 2 + 1; i<N-1; i++) {
                    for (int j = count; j < N-count; j++) {
                        sum += crops[i][j];
                    }
                            count++;
                            if(count == N/2) break;
                }
            //농장 크기가 1일때
            if (N == 1)
                sum = crops[0][0];

                System.out.println("#" + testCase++ +" " + sum);

        }
    }
}