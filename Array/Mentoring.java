package Array;

import java.util.Scanner;

public class Mentoring {
    public int solution(int[][] stu,int M,int N){
        int[][] temp = new int[N][N];
        int count = 0;

        for(int i =0;i<M;i++){
            for(int j=0;j<N;j++){
                for(int k=j+1;k<N;k++){
                    temp[stu[i][j]-1][stu[i][k]-1]++;
                    if(M==temp[stu[i][j]-1][stu[i][k]-1]) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Mentoring T = new Mentoring();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M  = sc.nextInt();
        int[][] stu = new int[M][N];
        for(int i =0;i<M;i++){
            for(int j=0;j<N;j++){
                stu[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(stu,M,N));
    }
}
