package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Peaks {
    //4방탐색
    public int solution(int[][] arr){
        int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
        int answer = 0;
        for(int row =0;row<arr.length;row++){
            for(int col=0;col<arr.length;col++){
                int max =Integer.MIN_VALUE;
               for(int w =0;w<4;w++) {
                   int nx = row + deltas[w][0];
                   int ny = col + deltas[w][1];
                   if(nx<0||ny<0||nx>=arr.length||ny>=arr.length) continue;
                   if(max<arr[nx][ny]) max=arr[nx][ny];
               }
               if(max<arr[row][col]) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Peaks T = new Peaks();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr));

    }
}
