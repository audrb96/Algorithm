package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_강의실배정_박명규 {
    static int N,ans;
    static int[][] time;
    static int endTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        time = new int[N][2];
        ans = 1;
        for(int i =0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[i][0] = start;
            time[i][1] = end;
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        endTime = time[0][1];


        for(int i =1;i<N;i++){
            if(time[i][0] >= endTime) {
                endTime = time[i][1];
                ans++;
            }
        }

        System.out.println(ans);


    }
}
