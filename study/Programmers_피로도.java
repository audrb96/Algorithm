package study;

class Programmers_피로도 {
    int[] selected;
    boolean[] isVisited;
    int answer;

    public int solution(int k, int[][] dungeons) {
        answer = -1;
        selected = new int[dungeons.length];
        isVisited = new boolean[dungeons.length];
        comb(0, dungeons.length, dungeons, k);

        return answer;
    }

    public void comb(int cnt, int N, int[][] dungeons,int k) {
        if(cnt == N) {
            int explore = 0;
            int totalStress = k;
            for(int i =0; i<selected.length; i++) {
                int temp = selected[i];
                int min = dungeons[temp][0];
                int stress = dungeons[temp][1];

                if(totalStress >= min) {
                    totalStress = totalStress - stress;
                    explore++;
                }
            }

            answer = Math.max(answer, explore);
            return;
        }

        for(int i =0; i< dungeons.length; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            selected[cnt] = i;
            comb(cnt+1, N, dungeons,k);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) {
        Programmers_피로도 solution = new Programmers_피로도();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int answer = solution.solution(k, dungeons);

        System.out.println(answer);
    }
}