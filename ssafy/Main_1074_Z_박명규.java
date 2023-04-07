package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z_박명규 {
    static int cnt = 0;
    //재귀

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solution((int) Math.pow(2,N),r,c);
        System.out.println(cnt);
    }
    //재귀를 통해 size와 사분면의 r,c를 넘겨준다.
    public static void solution(int size,int r,int c){
        if(size==1){
            return;
        }
        //r,c가 1사분면에 있을때
        if(r<size/2&&c<size/2){
            solution(size/2,r,c);
        }
        // 2사분면에 있을때
        else if(r<size/2&&c>=size/2){
            cnt+= size*size/4;
            solution(size/2,r,c-size/2);
        }
        // 3사분면에 있을때
        else if(r>=size/2&&c<size/2){
            cnt += size*size/4*2;
            solution(size/2,r-size/2,c);
        }
        //4사분면에 있을때
        else if(r>=size/2&& c>=size/2){
            cnt += size*size/4*3;
            solution(size/2,r-size/2,c-size/2);
        }
    }
}
