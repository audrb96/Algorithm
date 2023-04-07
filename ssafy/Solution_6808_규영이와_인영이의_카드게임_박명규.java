package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//순열
public class Solution_6808_규영이와_인영이의_카드게임_박명규 {
    static int[] numbers;
    static int win;
    static int lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            int[] card = new int[9];
            int[] leftCard = new int[9];
            boolean[] isCard = new boolean[19];
            numbers = new int[9];
            win=0;
            lose = 0;
            st = new StringTokenizer(br.readLine());
            for(int i =0;i<9;i++){
                String temp = st.nextToken();
                card[i] = Integer.parseInt(temp);
                isCard[Integer.parseInt(temp)] = true;
            }
            int c = 0;
            for(int i =1;i<19;i++){
                if(!isCard[i])
                    leftCard[c++] = i;
            }

            permutation(0,0,leftCard,card);
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.print(sb);
    }
    public static void permutation(int cnt,int flag,int[] leftCard,int[] card){
        if(cnt==9){
            int kyuScore = 0;
            int inScore = 0;
            for(int i =0;i<9;i++){
                if(card[i]>numbers[i]) kyuScore += card[i] + numbers[i];
                else inScore += card[i] + numbers[i];
            }
            if(kyuScore>inScore) win++;
            else if(kyuScore<inScore) lose++;

            return;
        }
        for(int i =0;i<9;i++){
            if((flag&1<<i)!=0) continue;
            numbers[cnt] = leftCard[i];
            permutation(cnt+1,flag | 1<<i,leftCard,card);

        }
    }
}
