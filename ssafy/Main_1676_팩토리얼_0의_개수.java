package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼_0의_개수 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int num2 = 0;
        int num5 = 0;

        for(int i = N; i>0; i--) {
            int div2Num = i;
            int div5Num = i;
            while ( div2Num%2 ==0 ) {
                div2Num /= 2;
                num2 ++;
            }
            while (div5Num%5 ==0) {
                div5Num /= 5;
                num5++;
            }
        }
        System.out.println(Math.min(num2,num5));


    }
}
