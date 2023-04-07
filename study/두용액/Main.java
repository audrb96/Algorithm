package study.두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int N;

    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        int[] arr = setArr(br);
        Arrays.sort(arr);
        int[] answer = twoPointer(arr);
        return answer;
    }

    private int[] twoPointer(int[] arr) {
        int i = 0;
        int j = N-1;

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (i < j) {
            if(Math.abs(arr[i] + arr[j]) < min) {
                min = Math.abs(arr[i] + arr[j]);
                answer[0] = arr[i];
                answer[1] = arr[j];
            }

            if(arr[i] + arr[j] < 0) {
                i++;
            } else if(arr[i] + arr[j] > 0) {
                j--;
            } else {
                answer[0] = arr[i];
                answer[1] = arr[j];
                break;
            }

        }
        return answer;
    }

    private int[] setArr(BufferedReader br) throws IOException {
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");

        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int[] answer = main.solution();
        System.out.println(answer[0] +" " + answer[1]);
    }
}
