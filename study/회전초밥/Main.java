package study.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    int N, d, k ,c;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setVar(br);
        int[] sushi = setSushi(br);
        int answer = twoPointer(sushi);

        br.close();
        return answer;
    }

    private int twoPointer(int[] sushi) {
        int i = k;
        int j = 0;
        int answer = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();
        for(int s = 0; s<k; s++) {
            set.add(sushi[s]);
        }
        answer = Math.max(answer, set.size() + (set.contains(c) ? 0 : 1));



        while (i < N+k-1) {
            set.add(sushi[i++]);
            set.remove(sushi[j++]);

            answer = Math.max(answer, set.size() + (set.contains(c) ? 0 : 1));
        }

        if(answer == Integer.MIN_VALUE) return 1;

        return answer;
    }

    private int[] setSushi(BufferedReader br) throws IOException {
        int[] sushi = new int[N];

        for(int i =0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        return sushi;
    }

    private void setVar(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        d = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        c = Integer.parseInt(line[3]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();

        System.out.println(answer);
    }
}
