package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2477_참외밭_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st;
        int hMax = Integer.MIN_VALUE;
        int wMax = Integer.MIN_VALUE;
        int sh = 0;
        int sw = 0;

        for(int i =0;i<6;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0;i<6;i++){
            if(i%2==1){
                hMax = Math.max(arr[i],hMax); //가장 긴 세로를 구한다.
            }
            if(i%2==0){
                wMax = Math.max(arr[i],wMax); //가장 긴 가로를 구한다.
            }
        }

        for(int i =0;i<6;i++){
            //한변의 앞뒤가 가장 긴 높이와 같으면 파여진 네모의 가로
            if(hMax==arr[(i+5)%6]+arr[(i+1)%6]){
                sw = arr[i];
            }
            //한변의 앞뒤가 가장 긴 가로와 같으면 파여진 네모의 세로
            if(wMax==arr[(i+5)%6]+arr[(i+1)%6]){
                sh = arr[i];
            }
        }
        //큰 네모에서 작은 네모의 넓이를 빼고 참외의 개수를 곱한다.
        int ans = (hMax*wMax-sw*sh)*N;
        System.out.println(ans);
    }
}
