package ssafy_live.pcs;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
    static int N, numbers[],totalCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //던진 주사위 횟수
        numbers = new int[N]; // 차례대로 던져진 주사위 눈의 수

        int M = sc.nextInt(); //던지기 모드(1-4)

        switch (M){
            case 1: //주사위 던지기1 : 중복 순열
                dice1(0);
                break;
            case 2: //주사위 던지기2 : 순열
                dice2(0,new boolean[7]);
                break;
            case 3:
                dice3(0,1); // 중복 조합
                break;
                case 4:
                dice4(0,1); // 조합
                break;
            default:
                break;
        }
        System.out.println("총 경우의 수 : "+ totalCnt);
    }
    //주사위 던지기 1 : 중복순열
    public static void dice1(int cnt) {
        if(cnt == N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i =1;i<=6;i++){
            numbers[cnt] = i;
            dice1(cnt+1);
        }
    }

    public static void dice2(int cnt,boolean[] isSelected){
        if(cnt==N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i =1;i<=6;i++){
            if(isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            dice2(cnt+1,isSelected);
            isSelected[i] = false;
        }
    }

    public static void dice3(int cnt,int start){
        if(cnt==N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i =start;i<=6;i++){
            numbers[cnt] = i;
            dice3(cnt+1,i); // i부터 시작 - 중복조합
        }
    }

    public static void dice4(int cnt,int start){
        if(cnt==N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i =start;i<=6;i++){
            numbers[cnt] = i;
            dice4(cnt+1,i+1);
        }
    }

}
