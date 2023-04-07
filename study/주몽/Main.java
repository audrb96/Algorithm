package study.주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int N,M;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setVar(br);
        int[] arr = setArr(br);
        Arrays.sort(arr);
        int answer = twoPointer(arr);
        br.close();
        return answer;
    }

    private int twoPointer(int[] arr) {
        int left = 0;
        int right = N-1;
        int cnt = 0;
        while (left < right) {
            if(arr[left] + arr[right] < M) {
                left++;
            } else if(arr[left] + arr[right] > M) {
                right--;
            } else {
                left++;
                cnt++;
            }
        }

        return cnt;
    }

    private int[] setArr(BufferedReader br) throws IOException {
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i =0; i<N;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }

    private void setVar(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();

        System.out.println(answer);
    }

}
