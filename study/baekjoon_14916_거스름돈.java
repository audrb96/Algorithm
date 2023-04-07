package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_14916_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int money = Integer.parseInt(br.readLine());
        boolean isOdd = money % 5 % 2 != 0;
        if(money == 1 || money == 3) {
            System.out.println(-1);
            return;
        }
        if(isOdd) {
            answer = (money / 5 -1) + (money - 5*(money/5-1))/2;
        } else {
            answer = money /5 + (money - 5*(money/5))/2;
        }
        System.out.println(answer);

    }
}
