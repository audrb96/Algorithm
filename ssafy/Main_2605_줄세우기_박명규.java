package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2605_줄세우기_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //중간에 삽입을 해야 하므로 LinkedList가 적합하다고 생각했다.
        List<Integer> line = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken()); //학생들이 뽑은 숫자
        }
        for(int i =0;i<N;i++){
            line.add(i-nums[i],i+1); //해당 인덱스에 뽑은 숫자만큼 앞으로 가서 삽입한다.
        }
        for (Integer integer : line) {
            System.out.print(integer+" ");
        }

    }
}
