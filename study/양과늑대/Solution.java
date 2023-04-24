package study.양과늑대;

class Solution {
    static class Node {
        int num;
        int animal;
        Node left;
        Node right;

        public Node(int num, int animal, Node left, Node right) {
            this.num = num;
            this.animal = animal;
            this.left = left;
            this.right = right;
        }

        public void addLeft(Node node) {
            left = node;
        }

        public void addRight(Node node) {
            right = node;
        }
    }

    int max;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Node rootNode = setNode(info, edges);
        max = Integer.MIN_VALUE;
        findSheep(rootNode,0,0);

        answer = max;
        return answer;
    }

    private void findSheep(Node node, int sheep, int wolf) {
        if(node == null || (sheep!=0 && wolf != 0 && sheep <= wolf)) return;

        if(node.animal == 0) {
            sheep  = sheep +1;
        } else {
            wolf = wolf +1;
        }

        max = Math.max(max, sheep+1);


        findSheep(node.left, sheep +1, wolf);
        findSheep(node.right, sheep +1, wolf);



    }

    public boolean addNode(Node node, int[] edge, int[] info) {
        if(node == null) return false;
        if(node.num == edge[0]) {
            if(node.left == null) {
                node.addLeft(new Node(edge[1], info[edge[1]], null, null ));
            } else {
                node.addRight(new Node(edge[1], info[edge[1]], null, null));
            }

            return true;
        }

        if(addNode(node.left, edge, info)) return true;
        if(addNode(node.right, edge,info)) return true;

        return false;
    }

    private Node setNode(int[] info, int[][] edges) {
        Node rootNode = new Node(0,0,null,null);

        for(int i =0; i<edges.length; i++) {
            int[] edge = edges[i];
            addNode(rootNode, edge, info);
        }
        return rootNode;
    }

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        Solution solution = new Solution();
        int answer = solution.solution(info, edges);
        System.out.println(answer);
    }

}