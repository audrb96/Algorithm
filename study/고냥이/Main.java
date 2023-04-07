package study.고냥이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    int N;
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int answer = twoPointer(word);
        br.close();
        return answer;
    }

    private int twoPointer(String word) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        int max = Integer.MIN_VALUE;

        while ( i < word.length()+1) {
            if(map.size() <= N && i < word.length()) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) +1);
                i++;
            } else {
                if(map.get(word.charAt(j)) == 1) map.remove(word.charAt(j));
                else map.put(word.charAt(j), map.get(word.charAt(j)) -1);
                j++;
            }

            if(max < i-j && map.size() <= N) {
                max = i-j;
            }

            if(i == j ) break;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
