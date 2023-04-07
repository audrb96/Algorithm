package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소_스패닝_트리_박명규 {
    static int V;
    static int E;
    static int T;
    static long ans;
    static boolean[] isVisited;

    static class Node implements Comparable<Node>{
        int next;
        long w;

        public Node(int next, long w) {
            this.next = next;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return (this.w - o.w) > 0 ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            isVisited = new boolean[V+1];

            ArrayList<Node>[] graph = new ArrayList[V+1];
            ans = 0;
            for(int i =0;i<=V;i++){
                graph[i] = new ArrayList<>();
            }
            for(int i =0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                long weight = Long.parseLong(st.nextToken());
                graph[from].add(new Node(to,weight));
                graph[to].add(new Node(from,weight));
            }

            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(1,0));

            int cnt = 0;

            while (!queue.isEmpty()){
                Node now = queue.poll();
                if(isVisited[now.next]) continue;

                ans += now.w;
                isVisited[now.next]  = true;
                if(++cnt == V) {
                    break;
                }

                for(int i=0;i<graph[now.next].size();i++){
                    Node nextNode = graph[now.next].get(i);
                    if(isVisited[nextNode.next]) continue;
                    queue.add(nextNode);
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
