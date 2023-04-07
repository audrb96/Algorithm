package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int testCase = 1;
        while (T-->0){
            //특정 위치에 삽입하는 로직이 필요하므로 LinkedList가
            // 가장 적합하다고 생각했다.
            List<String> list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                list.add(st.nextToken());
            }
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i =0;i<K;i++){
                st.nextToken(); //I 명령밖에 없으므로 한토큰을 패스
                int index = Integer.parseInt(st.nextToken()); //인덱스
                int num = Integer.parseInt(st.nextToken()); // 숫자의 갯수
                for(int j =0;j<num;j++){
                        list.add(index+j,st.nextToken()); //해당 인덱스부터 숫자의 갯수만큼 토큰을 넘겨받아서 삽입
                }
            }
            System.out.print("#"+testCase++ +" ");
            for(int i =0;i<10;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
