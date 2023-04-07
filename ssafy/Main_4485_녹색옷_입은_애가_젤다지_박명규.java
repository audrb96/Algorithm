package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷_입은_애가_젤다지_박명규 {

    static class Node implements Comparable<Node>{
        int x;
        int totalDistance;

        public Node(int x, int totalDistance) {
            super();
            this.x = x;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Node o) {
            return (this.totalDistance -o.totalDistance)>0?1:-1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = 0;
        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }
            int[] W = new int[N*N +1];

            for(int i = 0; i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++) {
                    W[N * i + j + 1] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayList<Node>[] graph = new ArrayList[N*N+1];
            for(int i = 0; i <=N*N ; i++) {
                graph[i] = new ArrayList<Node>();
            }

            for(int i = 1; i <= N*N; i++) {
                if((i-1) % N != 0) {
                    graph[i].add(new Node(i-1, W[i-1]));
                }
                if(i % N != 0) {
                    graph[i].add(new Node(i+1, W[i+1]));
                }
                if(i - N > 0) {
                    graph[i].add(new Node(i-N, W[i-N]));
                }
                if(i + N < N*N+1) {
                    graph[i].add(new Node(i+N, W[i+N]));
                }
            }

            boolean[] isVisited = new boolean[N*N+1];
            int[] dist = new int[N*N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1] = W[1];
            PriorityQueue<Node> pqueue = new PriorityQueue<Node>();

            pqueue.add(new Node(1, dist[1]));
            Node current = null;

            while(!pqueue.isEmpty()) {
                current = pqueue.poll();

                if(isVisited[current.x]) {
                    continue;
                }

                isVisited[current.x] = true;
                if(current.x == N*N) {
                    break;
                }

                for(int i = 0; i < graph[current.x].size(); i++) {
                    if(!isVisited[graph[current.x].get(i).x] && dist[graph[current.x].get(i).x] > current.totalDistance + graph[current.x].get(i).totalDistance) {
                        dist[graph[current.x].get(i).x] = current.totalDistance + graph[current.x].get(i).totalDistance;
                        pqueue.add(new Node(graph[current.x].get(i).x, dist[graph[current.x].get(i).x]));
                    }
                }

            }
            sb.append("Problem ").append(++T).append(": ").append(dist[N*N]).append("\n");

        }
        System.out.println(sb.toString());



    }

}
