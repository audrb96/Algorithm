package ssafy;

import java.util.Scanner;

public class Solution_2001_파리퇴치_박명규 {
    //SWEA 2001
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testCase = 1;

        while (T-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] area = new int[N][N];
            for(int i =0;i<N;i++){
                for(int j =0;j<N;j++){
                    area[i][j] = sc.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;

            for(int i =0;i<N-M+1;i++){
                for(int j=0;j<N-M+1;j++){
                    int sum = 0;
                    for(int r = 0;r<M;r++){
                        for(int c = 0;c<M;c++){
                            sum += area[i+r][j+c];
                        }
                    }
                    if(sum>max) max = sum;
                }
            }
            System.out.println("#"+ testCase++ + " "+max);
        }


    }
}
