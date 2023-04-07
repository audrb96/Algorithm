package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//부분집합
public class Main_2961_도영이가_만든_맛있는_음식_박명규 {
    static boolean[] isVisited;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] food = new int[N][2];
        isVisited = new boolean[N];
        min = Integer.MAX_VALUE;
        for(int i =0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            food[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }
        subset(0,food,N);
        System.out.println(min);

    }
    public static void subset(int cnt,int[][] food,int N){
        if(cnt==N){
            int sour = 1;
            int bitter = 0;
            boolean isZero = true;

            for(int i =0;i<N;i++){
                if(isVisited[i]){
                    isZero = false;
                    sour = sour*food[i][0];
                    bitter += food[i][1];
                }
            }
            if(!isZero) min = Math.min(min, Math.abs(sour-bitter));
            return;
        }

        isVisited[cnt] = true;
        subset(cnt+1,food,N);
        isVisited[cnt] = false;
        subset(cnt+1,food,N);
    }
}
