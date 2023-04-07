package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달_박명규 {
    //그리디
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int bon3 = N/3;
        for(int i =0;i<=bon3;i++){
            int leftKg = N - 3*i;
            if(leftKg%5==0){
                int bon5 = leftKg/5;
                min = Math.min(min,i+bon5);
            }
        }
        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}
