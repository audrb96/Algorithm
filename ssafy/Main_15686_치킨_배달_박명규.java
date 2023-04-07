package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨_배달_박명규 {
    static int N;
    static int M;
    static ArrayList<int[]> home;
    static  ArrayList<int[]> chick;
    static ArrayList<int[]> ans;
    static int min;
    //조합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chick = new ArrayList<>();
        ans = new ArrayList<>();

        min = Integer.MAX_VALUE;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) home.add(new int[]{i,j});
                if(temp == 2) chick.add(new int[]{i,j});
            }
        }
        combination(0,0,ans);
        System.out.println(min);
    }
    public static void combination(int cnt,int start,ArrayList<int[]> arr){
        if(cnt == M){
            int sum = 0;
            for(int i =0;i<home.size();i++){
                int tempMin = Integer.MAX_VALUE;
                for(int j =0;j<arr.size();j++){
                    tempMin = Math.min(tempMin,Math.abs(arr.get(j)[0] - home.get(i)[0]) + Math.abs(arr.get(j)[1] -home.get(i)[1]));
                }
                sum += tempMin;
            }
            min = Math.min(min,sum);
            return;
        }

        for(int i =start;i<chick.size();i++){
            arr.add(chick.get(i));
            combination(cnt+1,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
