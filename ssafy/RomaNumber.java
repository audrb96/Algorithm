package ssafy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RomaNumber {
    public static Set<Integer> set = new HashSet<>();
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[] Roma = {1,5,10,50};
        solution(Roma,0,0,0);
        int answer = set.size();
        System.out.println(answer);

    }
    public static void solution(int[] Roma, int cnt,int sum,int start){
        if(cnt==N){
            set.add(sum);
            return;
        }
        for(int i =start;i<4;i++){
            solution(Roma,cnt+1,sum+Roma[i],i);
        }
    }
}
