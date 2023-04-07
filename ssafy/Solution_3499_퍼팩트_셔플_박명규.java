package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3499_퍼팩트_셔플_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<String> A = new LinkedList<>();
            Queue<String> B = new LinkedList<>();

            for(int i =0;i<N-(N/2);i++){
                A.offer(st.nextToken());
            }
            for(int i =0;i<N/2;i++){
                B.offer(st.nextToken());
            }
            for(int i =0;i<N/2;i++){
             sb.append(A.poll()).append(" ");
             sb.append(B.poll()).append(" ");
            }
            if(!A.isEmpty())
                sb.append(A.poll());
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
