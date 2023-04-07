package study.등굣길;

import java.util.Arrays;

class Solution {


    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        boolean[][] isPuddle = new boolean[m+1][n+1];

        dp[1][1] = 1;

        for(int i =0; i< puddles.length; i++) {
            isPuddle[puddles[i][0]][puddles[i][1]] = true;
        }

        for(int i =1; i<m+1; i++) {
            for(int j =1; j<n+1; j++) {
                if(isPuddle[i][j]|| (i==1&&j==1)) continue;
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                dp[i][j] = dp[i][j]%1000000007;
            }
        }

        answer = dp[m][n];

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        int answer = solution.solution(m, n, puddles);
        System.out.println(answer);
    }
}