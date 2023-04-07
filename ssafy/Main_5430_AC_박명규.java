package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5430_AC_박명규 {
    static int T,N;
    static ArrayDeque<Integer> arr;
    static String function;
    static StringBuilder ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        ans = new StringBuilder();
        for(int tc = 1;tc<=T;tc++){
            arr = new ArrayDeque<>();
            StringTokenizer st;
            function = br.readLine();
            N = Integer.parseInt(br.readLine());
            StringBuilder line = new StringBuilder(br.readLine());
            line.deleteCharAt(0);
            line.deleteCharAt(line.length()-1);
            st = new StringTokenizer(line.toString(),"[],");
            for(int i =0;i<N;i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            solution();
        }
        System.out.print(ans);
    }

    private static void solution() {
        boolean dir = true;
        for(int i =0;i<function.length();i++){
            if(function.charAt(i) == 'R') {
                dir = !dir;
                continue;
            }

            if(dir) {
                if(arr.pollFirst() == null){
                    ans.append("error\n");
                    return;
                }
            }else {
                if(arr.pollLast() == null){
                    ans.append("error\n");
                    return;
                }
            }
        }

        ans.append("[");

        if(dir){
            while (!arr.isEmpty()){
                ans.append(arr.pollFirst()).append(",");
            }
        } else {
            while (!arr.isEmpty()){
                ans.append(arr.pollLast()).append(",");
            }
        }
        if(ans.charAt(ans.length()-1) == ',') {
            ans.deleteCharAt(ans.length()-1);
        };
        ans.append("]\n");
    }
}
