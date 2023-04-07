package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238_이항계수_구하기_박명규 {
    static long N,R;
    static int T,P;
    static long[] fac;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
            R = Long.parseLong(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            fac = new long[P+1];
            fac[0] = 1;

            for(int i = 1;i< P+1;i++){
                fac[i] = (fac[i-1]*i) % P;
            }

            long res = 1;
            long X,Y;

            while (N != 0 || R != 0){
                X = N%P;
                Y = R%P;
                if(X<Y) {
                    res = 0;
                    break;
                }
                res = (res*fac[(int)X]) % P;
                for(int i =0;i<P-2;i++){
                    res = (res * fac[(int) (X - Y)] * fac[(int) Y]) % P;
                }
                N /= P;
                R /= P;
            }

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.print(sb);
    }
}
