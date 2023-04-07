package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1459_걷기 {
    public static void main(String[] args) throws IOException {
        long answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int[] dist = new int[2];
        dist[0] = Integer.parseInt(line[0]);
        dist[1] = Integer.parseInt(line[1]);



        int oneStep = Integer.parseInt(line[2]);
        int crossStep = Integer.parseInt(line[3]);

        int rowStep = Math.min(oneStep*2 , crossStep);
        int rowLocation = Math.min(dist[0], dist[1]);
        int highLocation = Math.max(dist[0], dist[1]);

        answer += (long) rowStep * rowLocation;

        int remain = highLocation - rowLocation;

        if(oneStep > crossStep) {
            answer +=  ((long) remain/2 * crossStep*2 + remain%2*oneStep);
        } else {
            answer += (long)remain*oneStep;
        }
        System.out.println(answer);
    }
}
