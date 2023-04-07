package study.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int N;

    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] liquids = setLiquids(br);
        Arrays.sort(liquids);
        int[] answer = twoPointer(liquids);
        br.close();
        return answer;
    }

    private int[] twoPointer(int[] liquids) {
        int left = 0;
        int right = N-1;

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            int sum = liquids[left]+liquids[right];
            int tempLeft = liquids[left];
            int tempRight = liquids[right];

            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            }

            if(sum == 0) {
                return new int[]{tempLeft, tempRight};
            }

            if(min > Math.abs(sum)) {
                answer[0] = tempLeft;
                answer[1] = tempRight;
                min = Math.abs(sum);
            }

        }

        return answer;

    }

    private int[] setLiquids(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        int[] liquids = new int[N];

        for(int i =0; i<N; i++) {
            liquids[i] = Integer.parseInt(line[i]);
        }

        return liquids;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int[] answer = main.solution();
        System.out.println(answer[0] + " " + answer[1]);
    }
}
