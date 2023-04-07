package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1043_거짓말_박명규 {
    static int N,M,knowNum,ans;
    static int[] knowPeople;
    static ArrayList<Integer>[] connect;
    static boolean[] possible;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        connect  = new ArrayList[N+1];
        possible = new boolean[N+1];
        ans = M;
        party = new ArrayList[M];

        for(int i =1; i<N+1;i++){
            connect[i] = new ArrayList<>();
        }
        for(int i = 0;i<M;i++){
            party[i] = new ArrayList<>();
        }

        knowNum = Integer.parseInt(st.nextToken());
        knowPeople = new int[knowNum];
        for(int i =0;i<knowNum;i++){
            int temp = Integer.parseInt(st.nextToken());
            knowPeople[i] = temp;
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int[] temp = new int[people];
            for(int j=0;j<people;j++){
                    temp[j] = Integer.parseInt(st.nextToken());
                    party[i].add(temp[j]);
            }

            for(int j =0;j<people-1;j++){
                for(int k=j+1;k<people;k++){
                    connect[temp[j]].add(temp[k]);
                    connect[temp[k]].add(temp[j]);
                }
            }
        }

        for(int i =0;i<knowNum;i++){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(knowPeople[i]);
            boolean[] isVisited = new boolean[N+1];

            while (!queue.isEmpty()){
                int temp = queue.poll();
                if(isVisited[temp]) continue;
                isVisited[temp] = true;
                possible[temp] = true;
                for(int j =0; j<connect[temp].size();j++){
                    queue.add(connect[temp].get(j));
                }
            }
        }

        for(int i =0;i<party.length;i++){
            for(int j =0;j<party[i].size();j++){
                if(possible[party[i].get(j)]) {
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
