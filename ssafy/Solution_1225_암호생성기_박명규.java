package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        while (T --> 0){
            int testCase = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>(); //숫자들을 저장할 queue
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i =0;i<8;i++){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int count =1;
            while (true){ //사이클을 돈다.
                int temp;
                temp = queue.remove();
                temp= temp- count++; //감소량을 1씩증가하면서 뺀다.
                if(temp<=0){
                    queue.offer(0);
                    break;
                }
                queue.offer(temp);
                if(count == 6) count=1; //한 사이클을 돌았으면 처음부터
            }

            System.out.print("#"+testCase+" ");
            for(int i =0;i<8;i++){
                System.out.print(queue.poll()+" ");
            }
            System.out.println();
        }
    }
}
