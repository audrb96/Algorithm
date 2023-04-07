package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] area = new int[100][100];
        int sum = 0;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int ny = y;ny<y+10;ny++){
                for(int nx = x;nx<x+10;nx++){
                    // x y 기준으로 10개씩 돌면서
                    // area를 1로 바꾸어주고 sum값을 1씩 더해준다.
                    if(area[ny][nx]==1) continue;
                    area[ny][nx] = 1;
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
