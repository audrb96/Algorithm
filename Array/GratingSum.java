package Array;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class GratingSum {
    public int solution(int[][] arr){
        int max = 0;
        int RowSum = 0;
        int ColSum = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;
        for(int r = 0;r<arr.length;r++){
            for(int c =0;c<arr.length;c++){
                RowSum += arr[r][c];
            }
            if(RowSum>max){
                max = RowSum;
            }
            RowSum = 0;
        }
        for(int r = 0;r<arr.length;r++){
            for(int c =0;c<arr.length;c++){
                ColSum += arr[c][r];
            }
            if(ColSum>max){
                max = ColSum;
            }
            ColSum =0;
        }
        for(int i =0;i<arr.length;i++){
            diagonal1 += arr[i][i];
        }
        if(max<diagonal1) max = diagonal1;

        for(int i =0;i<arr.length;i++){
            diagonal2 += arr[i][arr.length-1-i];
        }
        if(max<diagonal2) max = diagonal2;
        return max;
    }
    public static void main(String[] args) {
        GratingSum T = new GratingSum();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++)
                arr[i][j] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
