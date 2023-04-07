package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_회전_초밥_박명규 {
    static int N,D,K,C,max,ans,kind;
    static int[] plate;
    static int[] eat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //접시수
        D = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
        K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        plate = new int[N];
        eat = new int[D+1];
        max = Integer.MIN_VALUE;
        ans = 0;
        kind = 0;

        for(int i =0;i<N;i++){
            plate[i] = Integer.parseInt(br.readLine());
        }
        int temp = 0;
        for(int i =0;i<K;i++){
            if(eat[plate[i]] == 0) kind++;
            eat[plate[i]] += 1;
        }
        if(eat[C] == 0 && N>=K) {
            temp ++;
        }
        ans = kind + temp;

        for(int i =0;i<N-1;i++){
            temp = 0;
            if(eat[plate[i]] > 1){
                eat[plate[i]] --;
            } else if(eat[plate[i]] == 1) {
                kind --;
                eat[plate[i]] --;
            }

            if(eat[plate[(i+K)%N]] == 0) {
                eat[plate[(i+K)%N]] ++;
                kind ++;
            }
            else{
                eat[plate[(i+K)%N]] ++;
            }
            if(eat[C] == 0  && N>=K ) temp ++;
            ans = Math.max(ans,kind+temp);
        }
        System.out.println(ans);
    }
}
