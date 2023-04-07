package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2503_숫자야구 {
    static int answer;
    static boolean[] isVisited;
    static String[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] question = new String[N][3];
        answer = 0;
        isVisited = new boolean[10];
        selected = new String[3];
        for(int i =0 ;i<question.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j =0; j<question[i].length; j++) {
                question[i][j] = st.nextToken();
            }
        }
        perm(0,question);

        System.out.println(answer);
    }

    public static void perm(int cnt, String[][] question) {
        if(cnt ==3) {
            boolean flag = true;
            String selectedNum  = "";

            for(int i =0; i<selected.length; i++) {
                selectedNum += selected[i];
            }

            for(int i =0; i<question.length; i++) {
                String[] temp = question[i];
                String num = temp[0];
                String strike = temp[1];
                String ball = temp[2];
                int tempStrike = 0;
                int tempBall = 0;

                for(int j =0; j<3; j++) {
                    char number = num.charAt(j);
                    if(number == selectedNum.charAt(j)) tempStrike ++;
                    else if(selectedNum.contains(number+"")) {
                        tempBall++;
                    }
                }

                if(Integer.parseInt(strike) != tempStrike || Integer.parseInt(ball) != tempBall) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
            return;
        }

        for(int i = 1; i<=9; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            selected[cnt] = Integer.toString(i);
            perm(cnt+1, question);
            isVisited[i] = false;
        }

    }

}
