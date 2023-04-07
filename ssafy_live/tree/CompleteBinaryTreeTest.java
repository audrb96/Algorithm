package ssafy_live.tree;

import java.util.PriorityQueue;

public class CompleteBinaryTreeTest {

    public static void main(String[] args) {
        int size = 9;
        CompleteBinaryTree tree  = new CompleteBinaryTree(size);

        for (int i = 0; i < size; i++) {
            tree.add((char)(65+i));
        }
//        tree.bfs();
//        tree.bfs2();
        PriorityQueue<Integer> a = new PriorityQueue<>();

        tree.dfsByPreOrder();

    }
}
