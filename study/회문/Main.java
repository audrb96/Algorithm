package study.회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];

        for(int i =0; i<T; i++) {
            String word = br.readLine();
            answer[i] = twoPointer(word, 0, 0,word.length()-1);
        }

        br.close();
        return answer;
    }

    private int twoPointer(String word,int cnt,int left,int right) {

        while (left < right) {
            if(cnt == 2) return cnt;
            if(word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
                continue;
            }

            if(cnt == 0) {
                return Math.min(twoPointer(word, cnt+1, left+1, right), twoPointer(word, cnt+1, left, right-1));
            }
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int[] answer = main.solution();
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
