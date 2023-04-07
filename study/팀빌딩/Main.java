package study.팀빌딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] team = setTeam(br);
        int answer = twoPointer(team);
        br.close();
        return answer;
    }

    private int twoPointer(int[] team) {
        int s =0;
        int e =N-1;

        int max = Integer.MIN_VALUE;

        while (s < e) {


        }

        return max;
    }

    private int[] setTeam(BufferedReader br) throws IOException {
        int[] team = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i =0; i<N; i++) {
            team[i] = Integer.parseInt(line[i]);
        }
        return team;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();

        System.out.println(answer);
    }
}
