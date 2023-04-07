package study.두개의탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N, sum;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] towers = setTowers(br);
        int answer = twoPointer(towers);
        br.close();
        return answer;
    }

    private int twoPointer(int[] towers) {
        int i =0;
        int j =0;

        int max = Integer.MIN_VALUE;
        int distance = 0;

        while (i<N+1) {
            max = Math.max(max, Math.min(distance, sum-distance));
            if(distance < sum-distance && i < N) {
                distance += towers[i];
                i++;
            } else {
                distance -= towers[j];
                j++;
            }
            if(i==j) break;
        }

        return max;
    }

    private int[] setTowers(BufferedReader br) throws IOException {
        int[] towers = new int[N];
        sum = 0;
        for(int i =0; i<N; i++) {
            towers[i] = Integer.parseInt(br.readLine());
            sum += towers[i];
        }
        return towers;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
