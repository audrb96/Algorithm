package study.리코쳇로봇;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Pos {
        int r;
        int c;
        int count;

        public Pos(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
    int[] start;
    boolean[][] isVisited;
    int[] dc = {0,1,0,-1};
    int[] dr = {1,0,-1,0};

    public int solution(String[] board) {
        int answer = 0;
        isVisited = new boolean[board.length][board[0].length()];
        start = new int[2];
        char[][] boardArr = setBoard(board);
        answer = bfs(boardArr);


        return answer;
    }

    private int bfs(char[][] boardArr) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(start[0], start[1], 0));
        isVisited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Pos temp = queue.poll();

            for(int i =0; i<4; i++) {
                int nr = temp.r;
                int nc = temp.c;

                while (nr + dr[i] >=0&&nc + dc[i]>=0&&nr + dr[i]< boardArr.length&&nc+dc[i] < boardArr[0].length&&boardArr[nr + dr[i]][nc + dc[i]] != 'D') {
                    nr = nr + dr[i];
                    nc = nc + dc[i];
                }

                if(isVisited[nr][nc]) continue;
                if(boardArr[nr][nc] == 'G') return temp.count+1;

                isVisited[nr][nc] = true;
                queue.add(new Pos(nr, nc, temp.count+1));
            }
        }

        return -1;
    }

    private char[][] setBoard(String[] board) {
        char[][] boardArr = new char[board.length][board[0].length()];
        for (int i = 0; i < boardArr.length; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                boardArr[i][j] = chars[j];
                if(chars[j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        return boardArr;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] board = {".D.R", "....", ".G..", "...D"};
        int answer = solution.solution(board);
        System.out.println(answer);
    }
}