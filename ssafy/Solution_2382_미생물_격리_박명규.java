package ssafy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2382_미생물_격리_박명규 {
    static class microbe {
        int r;
        int c;
        int dir;
        int num;

        public microbe(int r, int c, int dir, int num) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.num = num;
        }
    }
    static int T,N,M,K,ans;
    static int[][] map;
    static ArrayList<microbe> microbes;
    static int[] dc = {0,0,-1,1};
    static int[] dr = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int tc =1 ;tc<=T;tc++){
            st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][N];
            microbes = new ArrayList<>();



            for(int i =0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[row][col] = num;

                microbes.add(new microbe(row,col,dir-1,num));
            }

            for(int i =0;i<M;i++){
                ArrayList<microbe> temp = new ArrayList<>();
                for(int j = 0;j<microbes.size();j++){
                    int nr = microbes.get(j).r + dr[microbes.get(j).dir];
                    int nc = microbes.get(j).c + dc[microbes.get(j).dir];

                    if(nr ==0 || nc == N-1 || nr == N-1 || nc ==0) {
                        int tempDir = -1;
                        if(microbes.get(j).dir == 0 || microbes.get(j).dir == 1){
                            tempDir = microbes.get(j).dir == 0 ? 1 : 0;
                        }
                        if(microbes.get(j).dir == 2 || microbes.get(j).dir == 3){
                            tempDir = microbes.get(j).dir == 2 ? 3 : 2;
                        }

                        temp.add(new microbe(nr,nc,tempDir,microbes.get(j).num/2));
                    }
                    else {
                        temp.add(new microbe(nr,nc,microbes.get(j).dir,microbes.get(j).num));
                    }
                }

                map = new int[N][N];
                for(int j = temp.size()-1 ; j>=0 ;j--){
                    int row = temp.get(j).r;
                    int col = temp.get(j).c;

                    if(map[row][col] != 0){
                        int maxNum = Integer.MIN_VALUE;
                        int maxDir = Integer.MIN_VALUE;
                        int sum = 0;
                        for(int k = temp.size()-1; k>=0;k--){
                            if(temp.get(k).r == row && temp.get(k).c == col){
                                microbe mc = temp.remove(k);
                                sum += mc.num;
                                if(maxNum < mc.num) {
                                    maxDir = mc.dir;
                                    maxNum = mc.num;
                                }
                            }
                        }

                        temp.add(new microbe(row,col,maxDir,sum));
                        continue;
                    }

                    map[row][col] = temp.get(j).num;
                }
            microbes = temp;

            }
            for(int i =0;i<microbes.size();i++){
                ans += microbes.get(i).num;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
