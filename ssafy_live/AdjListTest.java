package ssafy_live;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
    static class Node{
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", link=" + link +
                    '}';
        }
    }
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int C = sc.nextInt();

        Node[] adjList = new Node[N];


        for(int i =0;i<C;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjList[from]  = new Node(to,adjList[from]);
            adjList[to] = new Node(from,adjList[to]);
        }
//        bfs(adjList,0);
        dfs(adjList,new boolean[N],0);
    }


    public static void bfs(Node[] adjList,int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current);

            //current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
            for (Node temp = adjList[current]; temp != null; temp=temp.link) {
                if(!visited[temp.vertex]){
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
    }

    public static void dfs(Node[] adjList,boolean[] visited,int current){
        visited[current] = true;
        System.out.println(current);

        for (Node temp = adjList[current]; temp != null; temp=temp.link) {
            if(!visited[temp.vertex]){
             dfs(adjList,visited,temp.vertex);
            }
        }
    }
}
