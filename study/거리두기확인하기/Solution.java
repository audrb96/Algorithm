package study.거리두기확인하기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    ArrayList<int[]> PIndex;
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i =0; i<places.length; i++) {
            char[][] matrix = setMatrix(places[i]);
            answer[i] = bfs(matrix);
        }

        return answer;
    }

    private int bfs(char[][] matrix) {
        int answer = 1;

        for(int i =0; i<PIndex.size(); i++) {
            int r = PIndex.get(i)[0];
            int c = PIndex.get(i)[1];
            boolean[][] isVisited = new boolean[5][5];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{r,c});
            isVisited[r][c] = true;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();

                for(int d = 0; d<4; d++) {
                    int nr = temp[0] + dr[d];
                    int nc = temp[1] + dc[d];
                    if(nr > 4 || nc > 4 || nr < 0 || nc < 0 || isVisited[nr][nc] || matrix[nr][nc] == 'X' || (Math.abs(r-nr) + Math.abs(c-nc)) > 2) continue;
                    if(matrix[nr][nc] == 'P') return 0;
                    isVisited[nr][nc] = true;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return answer;
    }

    private char[][] setMatrix(String[] place) {
        char[][] matrix = new char[5][5];
        PIndex = new ArrayList<>();

        for(int i =0; i<place.length; i++) {
            for(int j = 0;j<place[i].length(); j++) {
                matrix[i][j] = place[i].charAt(j);
                if(matrix[i][j] == 'P') PIndex.add(new int[]{i,j});
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = solution.solution(places);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}