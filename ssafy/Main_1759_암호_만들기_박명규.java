package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//조합
public class Main_1759_암호_만들기_박명규 {
    static int L,C;
    static char[] al;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        al = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<C;i++){
            al[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(al);
        backtracking(0,0);
    }
    public static void backtracking(int cnt,int start){
        if(cnt == L){
            int gCount = 0;
            int cCount = 0;
            for(int i =0;i<L;i++){
                if(sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i' || sb.charAt(i) == 'o' ||sb.charAt(i) == 'u') gCount++;
                else cCount++;
            }
            if(gCount<1 || cCount<2) return;
            System.out.println(sb);
            return;
        }

        for(int i =start;i<C;i++){
            sb.append(al[i]);
            backtracking(cnt+1,i+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}
