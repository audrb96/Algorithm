package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int i = N-1;
        int ans  =0;
        while (K!=0){
            if(arr[i] > K){
                i--;
                continue;
            }
            ans += K/arr[i];
            K = K%arr[i];
            i--;
        }

        System.out.println(ans);
    }
}
