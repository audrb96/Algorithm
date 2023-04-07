package ssafy_live.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    private char[] nodes;
    private int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int size) {
        nodes = new char[size + 1];
        SIZE = size;
    }

    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == SIZE;
    }

    public void add(char e) {
        if (isFull()) return;
        nodes[++lastIndex] = e;
    }

    public void bfs() {
        if (isEmpty()) return;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(nodes[curr]);

            if (curr * 2 <= lastIndex)
                queue.offer(curr * 2);
            if (curr * 2 + 1 <= lastIndex)
                queue.offer(curr * 2 + 1);
        }
    }

    public void bfs2() {
        if (isEmpty()) return;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        int level =0;
        while (!queue.isEmpty()) {
            System.out.print("level "+level+" : ");
            // 같은 너비의 노드들 모두 탐색
            int size = queue.size();
            while (--size >= 0) {
                int curr = queue.poll();
                System.out.print(nodes[curr] + "\t");

                if (curr * 2 <= lastIndex)
                    queue.offer(curr * 2);
                if (curr * 2 + 1 <= lastIndex)
                    queue.offer(curr * 2 + 1);
            }
            level++;

            System.out.println();
        }
    }
    public void dfsByPreOrder(){
        System.out.println("dfsByPreOrder");
        dfsByPreOrder(1);
        System.out.println();
    }

    private void dfsByPreOrder(int current) {
        if(current>lastIndex) return;

        System.out.print(nodes[current] +" ");
        // 현재노드의 자식노드들 방문

        dfsByPreOrder(current*2);
        dfsByPreOrder(current*2+1);
    }
    public void dfsByInOrder(){
        System.out.println("dfsByInOrder");
        dfsByInOrder(1);
        System.out.println();
    }
    private void dfsByInOrder(int current) {
        if(current>lastIndex) return;

        dfsByInOrder(current*2);
        System.out.print(nodes[current] +" ");
        dfsByInOrder(current*2+1);
    }

    public void dfsByPostOrder(){
        System.out.println("dfsByInOrder");
        dfsByPostOrder(1);
        System.out.println();
    }
    private void dfsByPostOrder(int current) {
        if(current>lastIndex) return;

        dfsByPostOrder(current*2);
        dfsByPostOrder(current*2+1);
        System.out.print(nodes[current] +" ");
    }
}
