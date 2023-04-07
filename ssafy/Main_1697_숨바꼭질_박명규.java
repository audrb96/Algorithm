package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        boolean[] isVisited = new boolean[100001];
        queue.add(new int[]{N,0});
        isVisited[N] =true;

        while (!queue.isEmpty()){
            int[] temp = queue.poll();

            if(temp[0]*2<=100000 && !isVisited[temp[0]*2]) {
                isVisited[temp[0]*2] = true;
                queue.add(new int[]{temp[0]*2,temp[1]+1});
                if(temp[0]*2 == K) {
                    count = temp[1]+1;
                    break;
                }
            }

            if(temp[0]+1 <= 100000 && !isVisited[temp[0]+1]) {
                isVisited[temp[0]+1] = true;
                queue.add(new int[]{temp[0]+1,temp[1]+1});
                if(temp[0]+1 == K) {
                    count = temp[1]+1;
                    break;
                }
            }

            if(temp[0]-1 >= 0 && !isVisited[temp[0]-1]) {
                isVisited[temp[0]-1] = true;
                queue.add(new int[]{temp[0]-1,temp[1]+1});
                if(temp[0]-1 == K) {
                    count = temp[1]+1;
                    break;
                }
            }

        }
        System.out.println(count);

    }
}
