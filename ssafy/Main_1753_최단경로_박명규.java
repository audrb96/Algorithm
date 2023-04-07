package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//다익스트라 알고리즘
public class Main_1753_최단경로_박명규 {
    public static class Node{
        int vertex, weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        Node[] adjMatrix = new Node[V+1];
        for(int i =0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from] = new Node(to,Integer.parseInt(st.nextToken()), adjMatrix[from]);
        }

        int[] distance = new int[V+1];
        boolean[] isVisited = new boolean[V+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[K] = 0;
        int min,current = 1;

        for(int c=1;c<V+1;c++){
           min = Integer.MAX_VALUE;
            for(int i =1;i<V+1;i++){
                if(!isVisited[i] && min>distance[i]){
                    min = distance[i];
                    current = i;
                }
            }
            isVisited[current] =true;
           for(Node temp = adjMatrix[current]; temp!=null;temp=temp.next){
               if(!isVisited[temp.vertex] && distance[temp.vertex] > min + temp.weight){
                   distance[temp.vertex] = min+temp.weight;
               }
           }
        }
        for(int i =1;i<V+1;i++){
            if(distance[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }


    }
}
