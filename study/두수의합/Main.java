package study.두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int T;
    int n,K;

    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];
        for(int i =0; i<T; i++) {
            setVar(br);
            int[] arr = setArr(br);
            Arrays.sort(arr);
            answer[i] = twoPointer(arr);
        }
        br.close();
        return answer;
    }

    private int twoPointer(int[] arr) {
        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        while (left < right) {
            int abs = Math.abs(K-(arr[left] + arr[right]));

            if(K < arr[left] + arr[right]) {
                right--;
            } else if(K > arr[left] + arr[right]) {
                left ++;
            } else {
                left++;
            }

            if(min > abs) {
                min = abs;
                cnt = 1;
            } else if(min == abs) {
                cnt++;
            }
        }

        return cnt;
    }

    private int[] setArr(BufferedReader br) throws IOException {
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i =0; i<n;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        return arr;
    }

    private void setVar(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int[] ans = main.solution();
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
