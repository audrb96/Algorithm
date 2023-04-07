package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6064_카잉_달력_박명규 {
    static int M,N,x,y,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int year = 0;
            int i =0;
            int max = M*N/gcd(M,N);
            while (year <= max){
                year = i*M +x;
                if((year-y)%N ==0 ) {
                    break;
                }
                i++;
            }
            if(year > max) year = -1;
            sb.append(year).append("\n");
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        if(b ==0 ) {
            return a;
        }
        return gcd(b,a%b);
    }
}
