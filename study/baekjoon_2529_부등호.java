package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2529_부등호 {
    static Long maxAnswer = Long.MIN_VALUE;
    static Long minAnswer = Long.MAX_VALUE;

    static String maxString;
    static String minString;

    static int[] selected;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        selected = new int[N+1];
        isVisited = new boolean[10];


        String line = br.readLine();
        String[] array = line.split(" ");

        perm(0,N+1, array);

        System.out.println(maxString);
        System.out.println(minString);

    }
    public static void perm(int cnt, int N, String[] array) {
        if(cnt == N) {
            boolean valid = true;
            String nums = "";
            for(int i =0; i<N-1; i++) {
                String temp = array[i];
                int now = selected[i];
                int next = selected[i+1];
                if(temp.equals("<")) {
                    if(now >= next) {
                        valid = false;
                        break;
                    }
                }
                if(temp.equals(">")) {
                    if(now<= next){
                        valid = false;
                        break;
                    }
                }
            }
            for(int i =0; i<N;i++) {
                nums += Integer.toString(selected[i]);
            }


            if(valid) {
                if(maxAnswer < Long.parseLong(nums)) {
                    maxAnswer = Long.parseLong(nums);
                    maxString = nums;
                }
                if(minAnswer > Long.parseLong(nums)) {
                    minAnswer = Long.parseLong(nums);
                    minString = nums;
                }
            }

            return;
        }

        for(int i =0; i<10; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            selected[cnt] = i;
            perm(cnt+1, N,array);
            isVisited[i] = false;
        }
    }
}
