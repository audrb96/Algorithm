package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_최장수열길이_박명규 {
    static int T;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for(int i =0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] LIS = new int[N];
            for(int i =0;i<N;i++){
                LIS[i] = 1;
                for(int j=0;j<i;j++){
                    if(arr[j] < arr[i] && LIS[i] < 1+LIS[j])
                        LIS[i] = 1+LIS[j];
                }
            }
            Arrays.sort(LIS);
            sb.append("#").append(tc).append(" ").append(LIS[N-1]).append("\n");
        }
        System.out.println(sb);
    }
}
