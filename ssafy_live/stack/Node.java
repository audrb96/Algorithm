package ssafy_live.stack;

public class Node {
    String data; //data 필드
    Node link;//link 필드

    public Node(String data, Node node) {
        this.data = data;
        this.link = node;
    }

    public Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", node=" + link +
                '}';
    }
}
