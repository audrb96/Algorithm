package study.다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    int G;

    public ArrayList<Integer> solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = twoPointer();
        br.close();
        return answer;
    }

    private ArrayList<Integer> twoPointer() {
        ArrayList<Integer> answer = new ArrayList<>();
        int i =1;
        int j =1;


        while (Math.pow(i,2) - Math.pow(i-1,2) <= G) {
            int weight = (int)(Math.pow(i,2) - Math.pow(j,2));
            if(weight == G) {
                answer.add(i);
            }

            if(weight <= G ) {
                i++;
            } else {
                j++;
            }

        }

        return answer;

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        ArrayList<Integer> answer = main.solution();
        if(answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (Integer integer : answer) {
                System.out.println(integer);
            }
        }
    }
}
