package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525_IOIOI_박명규 {
    static int N,M,ans;
    static char[] arr;
    static int[] oNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ans = 0;
        arr = br.readLine().toCharArray();
        oNum = new int[arr.length];

        for(int i =1; i<M-1;i++){
            if(arr[i] == 'O' && arr[i+1] == 'I'){
                oNum[i+1] = oNum[i-1] +1;
            }

            if(oNum[i+1] >=  N && arr[i+1 - 2*N] == 'I'){
                ans +=1;
            }
        }
        System.out.print(ans);

    }
}
