package study.수고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int N;
    int M;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setNM(br);
        int[] array = setArray(br);
        Arrays.sort(array);
        int answer = twoPointer(array);
        br.close();
        return answer;
    }

    private int twoPointer(int[] array) {


        int i = 0;
        int j = 0;
        int answer = Integer.MAX_VALUE;


        while ( i < N) {
            if(array[i] - array[j] < M) {
                i++;
                continue;
            }

            if(array[i] - array[j] == M) {
                answer = M;
                break;
            }

            answer = Math.min(answer, array[i] - array[j]);
            j++;
        }
        return answer;
    }

    private void setNM(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
    }

    private int[] setArray(BufferedReader br) throws IOException {
        int[] array = new int[N];

        for(int i =0; i<N;i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        return array;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();

        System.out.println(answer);
    }
}
