package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2012_등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        int[] expect = new int[N];

        for(int i =0; i<N;i++) {
            expect[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expect);

        for(int i =1; i<=N;i++) {
            answer += Math.abs(expect[i-1] - i);
        }

        System.out.println(answer);
    }
}
