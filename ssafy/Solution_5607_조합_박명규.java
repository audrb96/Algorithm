package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합_박명규 {
    static int T,N,R;
    static long[] fac;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        fac = new long[1000001];
        fac[0] = 1;
        for(int i = 1;i< fac.length;i++){
            fac[i] = (fac[i-1]*i) % 1234567891;
        }

        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            long ans = (fac[N] * pow((fac[R]*fac[N-R])%1234567891,1234567891-2))%1234567891;
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static long pow(long a, long b) {
        if(b==0)
            return 1;
        long ans = pow(a,b/2);
        long next = (ans*ans) % 1234567891;
        if(b%2==0){
            return next;
        } else{
            return (next*a)%1234567891;
        }

    }
}
