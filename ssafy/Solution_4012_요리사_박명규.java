package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//조합
public class Solution_4012_요리사_박명규 {
    static int[][] S;
    static int N;
    static boolean[] isSelected;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            isSelected = new boolean[N];
            for(int i =0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0,0);
            System.out.println("#"+tc+" "+min);
        }
    }
    public static void combination(int cnt,int start){
        if(cnt==N/2){
            ArrayList<Integer> foodA = new ArrayList<>();
            ArrayList<Integer> foodB = new ArrayList<>();
            int sumA = 0;
            int sumB = 0;

            for(int i =0;i<N;i++){
                if(isSelected[i]) foodA.add(i);
                else foodB.add(i);
            }
            for(int i =0;i<foodA.size()-1;i++){
                for(int j=i+1;j<foodA.size();j++){
                    sumA += S[foodA.get(i)][foodA.get(j)];
                    sumA += S[foodA.get(j)][foodA.get(i)];
                }
            }

            for(int i =0;i<foodB.size()-1;i++){
                for(int j=i+1;j<foodB.size();j++){
                    sumB += S[foodB.get(i)][foodB.get(j)];
                    sumB += S[foodB.get(j)][foodB.get(i)];
                }
            }
            min = Math.min(min,Math.abs(sumA-sumB));
            return;
        }
        for(int i =start;i<N;i++){
            isSelected[i]=true;
            combination(cnt+1,i+1);
            isSelected[i] =false;
        }
    }

}
