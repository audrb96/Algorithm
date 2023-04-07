package study.민서의응급수술;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static class Neuron {
        int to;
        int from;

        public Neuron(int to, int from) {
            this.to = to;
            this.from = from;
        }
    }

    int[] parent;

    public void makeSet() {
        parent = new int[N+1];
        for(int i =1; i<N+1; i++) {
            parent[i] = i;
        }
    }

    public int findSet(int a) {
        if(parent[a] == a) return a;
        return parent[a] = findSet(parent[a]);
    }

    public boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }

    int N,M;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        makeSet();
        Neuron[] neurons = setNeurons(br);
        int answer = connectNeuron(neurons);
        br.close();
        return answer;
    }

    private int connectNeuron(Neuron[] neurons) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (Neuron neuron : neurons) {
            if(!union(neuron.to, neuron.from)) {
                cnt++;
            }
        }
        for(int i =1; i<N+1; i++) {
            set.add(findSet(i));
        }

        cnt += set.size()-1;

        return cnt;
    }

    private Neuron[] setNeurons(BufferedReader br) throws IOException {
        Neuron[] neurons = new Neuron[M];

        for(int i =0; i<M; i++) {
            String[] line = br.readLine().split(" ");
            neurons[i] = new Neuron(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }

        return neurons;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
