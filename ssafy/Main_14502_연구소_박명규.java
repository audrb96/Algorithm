package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_박명규 {
    static int N;
    static int M;
    static int[][] area;
    static int[] selected;
    static ArrayList<int[]> arrayList;
    static int max;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        selected = new int[3];
        arrayList = new ArrayList<>();
        max = Integer.MIN_VALUE;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] == 0) arrayList.add(new int[]{i,j});
            }
        }
        int K = arrayList.size();

        combination(0,0,K);
        System.out.println(max);
    }
    public static void combination(int cnt,int start, int K){
        if(cnt == 3){
            int[][] temp = new int[N][M];
            for(int i=0; i<area.length; i++){
                System.arraycopy(area[i], 0, temp[i], 0, area[0].length);
            }

            for(int i =0;i<3;i++){
                int[] tmp = arrayList.get(selected[i]);
                temp[tmp[0]][tmp[1]] = 1;
            }

            for(int i =0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(temp[i][j] != 2) continue;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});

                    while (!queue.isEmpty()){
                        int[] index = queue.poll();
                        for(int d = 0;d<4;d++){
                            int nx = index[1] + dx[d];
                            int ny = index[0] + dy[d];
                            if(nx>M-1||nx<0||ny>N-1||ny<0||temp[ny][nx] != 0) continue;
                            temp[ny][nx] = 2;
                            queue.add(new int[]{ny,nx});
                        }
                    }
                }
            }

            int count = 0;
            for(int i =0;i<N;i++){
                for(int j =0;j<M;j++){
                    if(temp[i][j]== 0) count++;
                }
            }
            max = Math.max(max,count);
            return;
        }

        for(int i =start;i<K;i++){
            selected[cnt] = i;
            combination(cnt+1,i+1,K);
        }
    }

}
