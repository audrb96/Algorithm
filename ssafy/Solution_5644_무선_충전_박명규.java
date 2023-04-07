package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_5644_무선_충전_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[] dx = {0,0,1,0,-1};
        int[] dy = {0,-1,0,1,0};

        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int[] moveA = new int[M];
            int[] moveB = new int[M];
            int[][] location = new int[A][2];
            int[][] CP = new int[A][2];
            int XA = 1;
            int YA = 1;
            int XB = 10;
            int YB = 10;
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i =0;i<M;i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i =0;i<M;i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =0;i<A;i++){
                st = new StringTokenizer(br.readLine());
                location[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
                CP[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            }

            for(int i=0;i<=M;i++){
                //움직임
                int max = 0;
                ArrayList<int[]> listA = new ArrayList<>();
                ArrayList<int[]> listB = new ArrayList<>();
                for(int j=0;j<A;j++){//ap갯수만큼
                 if(CP[j][0]>=(Math.abs(XA-location[j][0])+Math.abs(YA-location[j][1]))){
                     listA.add(new int[]{j,CP[j][1]});
                 }
                 if(CP[j][0]>=(Math.abs(XB-location[j][0])+Math.abs(YB-location[j][1]))){
                    listB.add(new int[]{j,CP[j][1]});
                 }
                }
                if(i<=M-1){
                    XA = XA + dx[moveA[i]];
                    XB = XB + dx[moveB[i]];
                    YA = YA + dy[moveA[i]];
                    YB = YB + dy[moveB[i]];
                }

                if(listA.isEmpty()&&listB.isEmpty()) continue;
                if(!listA.isEmpty()&&listB.isEmpty()){
                    for(int a =0;a<listA.size();a++){
                        max = Math.max(max,listA.get(a)[1]);
                    }
                }
                else if(!listB.isEmpty()&&listA.isEmpty()){
                    for(int b =0;b<listB.size();b++){
                        max = Math.max(max,listB.get(b)[1]);
                    }
                }
                else{
                    for(int a = 0;a<listA.size();a++){
                        for(int b=0;b<listB.size();b++){
                            if(listA.get(a)[0]==listB.get(b)[0]){
                                max = Math.max(max,listA.get(a)[1]);
                            }
                            else{
                                max = Math.max(max,listA.get(a)[1]+listB.get(b)[1]);
                            }
                        }
                    }
                }
                sum+=max;
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
