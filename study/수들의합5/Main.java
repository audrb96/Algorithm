package study.수들의합5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = twoPointer();
        br.close();
        return answer;
    }

    private int twoPointer() {
        int i =1;
        int j =1;

        int cnt = 0;
        int sum = 0;

        while (i<N+2) {
            if(sum < N) {
                sum += i;
                i++;
            } else {
                sum -= j;
                j++;
            }

            if(sum == N) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
