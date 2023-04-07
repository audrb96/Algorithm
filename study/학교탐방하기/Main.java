package study.학교탐방하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Load {
        int to;
        int from;
        int stress;

        public Load(int to, int from, int stress) {
            this.to = to;
            this.from = from;
            this.stress = stress;
            }
        }
        int[] parents;
        int N,M;

        private void makeSet() {
            parents = new int[N+1];

            for(int i =0; i<N+1;i++) {
                parents[i] = i;
            }
        }

        private int findSet(int a) {
            if(parents[a] == a) return a;
            return parents[a] = findSet(parents[a]);
        }

        private boolean union(int a, int b) {
            int aRoot = findSet(a);
            int bRoot = findSet(b);
            if(aRoot == bRoot) return false;
            parents[bRoot] = aRoot;
            return true;
        }

        public int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            setNM(br);
            Load[] loads = setLoads(br);
            int firstLoad = loads[0].stress;
            Arrays.sort(loads, (o1, o2) -> o1.stress - o2.stress);
            makeSet();
            int best = kruskal(loads, firstLoad);
            Arrays.sort(loads, (o1, o2) -> o2.stress - o1.stress);
            makeSet();
            int worst = kruskal(loads, firstLoad);

            return (int)(Math.pow(worst, 2) - Math.pow(best, 2));
        }

        private int kruskal(Load[] loads, int firstLoad) {
            int result = 0;
            int cnt = 0;

            union(0,1);
            result += firstLoad;
            cnt++;

            for (Load load : loads) {
                if(union(load.to, load.from)) {
                    result += load.stress;
                    if(++cnt == N) break;
                }
            }

            return result;
        }

        private Load[] setLoads(BufferedReader br) throws IOException {
            Load[] loads = new Load[M+1];

            for(int i =0; i<M+1; i++) {
                String[] line = br.readLine().split(" ");
                loads[i] = new Load(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2].equals("0") ? 1 : 0);
            }

            return loads;
        }

        private void setNM(BufferedReader br) throws IOException {
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);
        }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
