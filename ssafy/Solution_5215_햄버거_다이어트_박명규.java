package ssafy;

import java.util.Scanner;

/**
 * 부분집합문제, 재료를 선택했을때와 선택하지 않았을때
 */
public class Solution_5215_햄버거_다이어트_박명규 {
    static int N,L;
    static int[] score, cal;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int tc = 1;
        while (testCase -->0){
            N = sc.nextInt();
            L = sc.nextInt();
            score = new int[N];
            cal = new int[N];

            for(int i =0;i<N;i++){
                score[i] = sc.nextInt(); //점수를 저장한 배열
                cal[i] = sc.nextInt(); //칼로리를 저장한 배열
            }
            solution(0,0,0);
            System.out.println("#"+tc+++" " + max);
            max = 0;
        }
    }
    public static void solution(int cnt, int curScore,int curCal){
            if(curCal>L) return; //제한 칼로리를 넘으면 return;
            if(cnt==N){
                if(max<curScore) max = curScore;
                return;
            }
           solution(cnt+1,curScore+score[cnt],curCal+cal[cnt]); //선택한 경우
            solution(cnt+1,curScore,curCal);//선택하지 않은 경우
    }
}
