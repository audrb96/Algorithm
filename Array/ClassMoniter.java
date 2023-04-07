package Array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClassMoniter {
    public int solution(int[][] c,int N){
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int maxIndex=0;
        for(int i =0;i<N;i++){
            for(int j =0;j<5;j++){
                for(int k =0;k<N;k++){
                 if(c[i][j] == c[k][j]) set.add(k);
                }
            }
            if(max<set.size()){
                maxIndex=i;
                max = set.size();
            }
            set.clear();
        }
        return maxIndex+1;
    }

    public static void main(String[] args) {
        ClassMoniter T = new ClassMoniter();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] c = new int[N][5];
        for(int i =0;i<N;i++){
         for(int j = 0; j<5;j++){
             c[i][j] = sc.nextInt();
         }
        }
        System.out.println(T.solution(c,N));
    }
}
