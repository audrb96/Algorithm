package ssafy;

import java.util.Scanner;
//달팽이 배열
public class Solution_1954_달팽이_숫자_박명규 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testCase = 1;

        while(T-- >0){
            int N = sc.nextInt();
            int count = 1;
            int [][] snail = new int[N][N];
            int x= 0;
            int y =0;
            int d =0;
            snail[0][0] = count++;
            while (count<=N*N){
                int[] dx = {1,0,-1,0};
                int[] dy = {0,1,0,-1};
                int X,Y;
                X = x+dx[d];
                Y = y+dy[d];
                if(X>N-1||Y>N-1||X<0||Y<0||snail[Y][X]!=0) {
                    d++;
                    d=d%4;
                    X = x+dx[d];
                    Y = y+dy[d];
                }
                snail[Y][X] = count++;
                x=X;
                y=Y;
            }

            System.out.println("#"+testCase++);
            for (int[] ints : snail) {
                for (int anInt : ints) {
                    System.out.print(anInt+" ");
                }
                System.out.println();
            }
        }
    }
}
