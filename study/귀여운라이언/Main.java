package study.귀여운라이언;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N,K;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setVar(br);
        int[] dolls = setDolls(br);
        int answer = twoPointer(dolls);
        br.close();
        return answer;
    }

    private int twoPointer(int[] dolls) {
        int i = 0;
        int j = 0;

        int cnt = 0;
        int min = Integer.MAX_VALUE;

        while (i < N+1) {
            if(cnt < K && i<N) {
                if(dolls[i] == 1) cnt++;
                i++;
                continue;
             }

            if(cnt >= K) min = Math.min(min, i-j);
            if(dolls[j] == 1) cnt--;
            j++;

            if(i == j) i++;
        }
        if(min == Integer.MAX_VALUE) return -1;

        return min;
    }

    private int[] setDolls(BufferedReader br) throws IOException {
        int[] dolls = new int[N];
        String[] line = br.readLine().split(" ");

        for(int i =0; i<N; i++) {
            dolls[i] = Integer.parseInt(line[i]);
        }

        return dolls;
    }

    private void setVar(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
