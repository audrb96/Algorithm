package study.겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N,K;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setVar(br);
        int[] arr = setArr(br);
        int answer = twoPointer(arr);
        br.close();
        return answer;
    }

    private int twoPointer(int[] arr) {
        int i =0;
        int j =0;

        int[] used = new int[100001];
        int max = 0;

        while (i<N+1) {
            if(i<N && used[arr[i]] < K) {
                used[arr[i]]++;
                i++;
                continue;
            }

            max = Math.max(max, i-j);
            used[arr[j]]--;
            j++;

            if(i == j) i++;
        }
        return max;
    }

    private int[] setArr(BufferedReader br) throws IOException {
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
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
