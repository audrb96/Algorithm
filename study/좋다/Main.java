package study.좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int N;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = setArr(br);
        Arrays.sort(arr);
        int answer = twoPointer(arr);
        br.close();
        return answer;
    }

    private int twoPointer(int[] arr) {
        int answer = 0;


        for( int i =0; i<N; i++) {
            int number = arr[i];
            int left = 0;
            int right = N-1;

            while (left < right) {
                if(left == i) {
                    left++;
                    continue;
                }
                else if(right == i) {
                    right--;
                    continue;
                }

                if(arr[left] + arr[right] < number) left++;
                else if(arr[left] + arr[right] > number) right--;
                else {
                    answer++;
                    break;
                }
            }

        }


        return answer;
    }

    private int[] setArr(BufferedReader br) throws IOException {
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");
        for(int i =0; i<N;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
