package study.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N;
    int S;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setNS(br);
        int[] sequence = setSequence(br);
        int answer = twoPointer(sequence);
        br.close();
        return answer;
    }

    private int twoPointer(int[] sequence) {
        int sum = 0;
        int length = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        for(;left<N;left++) {
            while (sum < S && right < N) {
                sum += sequence[right++];
            }

            if(right - left < length && sum >=S) {
                length = right -left;
            }

            sum -= sequence[left];
        }

        if(length == Integer.MAX_VALUE) return 0;

        return length;
    }

    private int[] setSequence(BufferedReader br) throws IOException {
        int[] sequence = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i =0; i<N; i++) {
            sequence[i] = Integer.parseInt(line[i]);
        }

        return sequence;
    }

    private void setNS(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();

        System.out.println(answer);
    }
}
