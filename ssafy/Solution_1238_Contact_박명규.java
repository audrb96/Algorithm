package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1238_Contact_박명규 {
    static class Node{
        int vertax;
        Node link;

        public Node(int vertax, Node link) {
            this.vertax = vertax;
            this.link = link;
        }

    }

    static int N,V;
    static List<Integer> ans;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            Node[] adjList = new Node[500];
            ans = new ArrayList<>();
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int i =0 ;i<N/2;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to,adjList[from]);
            }
            bfs(adjList,V);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(Node[] adjList,int start){
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();

        boolean[] visited = new boolean[500];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){

            int current = queue.poll();
            ans.add(current);

            for(Node temp = adjList[current];temp != null; temp=temp.link){
                if(visited[temp.vertax]) continue;
                queue1.offer(temp.vertax);
                visited[temp.vertax] = true;
            }

           if(queue.isEmpty()&&(!queue1.isEmpty())){
               ans.clear();
               int size = queue1.size();
               for(int i =0;i<size;i++){
                   queue.add(queue1.poll());
               }
           }
           else if(queue.isEmpty()){
                ans.sort((o1,o2)->(o2-o1));
                max = ans.get(0);
           }
        }
    }
}
