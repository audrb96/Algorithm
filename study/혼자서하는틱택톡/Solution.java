package study.혼자서하는틱택톡;

class Solution {
    int OCount;
    int XCount;
    int totalCount = 0;

    public int solution(String[] board) {
        int answer = -1;
        OCount = 0;
        XCount = 0;

        char[][] boardArr = setBoard(board);
        answer = isAble(isWin(boardArr));

        return answer;
    }

    private int isAble(boolean[] win) {

        if(OCount-XCount > 1 || OCount - XCount < 0) return 0;
        if(totalCount == 9 && OCount - XCount != 1) return 0;
        if(win[0] && win[1]) return 0;
        if(win[0] && OCount == XCount) return 0;
        if(win[1] && XCount < OCount ) return 0;

        return 1;
    }

    private boolean[] isWin(char[][] boardArr) {
        boolean[] ret = new boolean[2];

        for(int i =0; i<3; i++) {
                int O = 0;
                int X = 0;
                for(int j =0; j<3; j++) {
                    if(boardArr[i][j] == 'O') O++;
                    else if(boardArr[i][j] == 'X') X++;
                }
                if(O == 3) ret[0] = true;
                else if(X == 3) ret[1] = true;

                O = 0;
                X = 0;
            for(int j =0; j<3; j++) {
                if(boardArr[j][i] == 'O') O++;
                else if(boardArr[j][i] == 'X') X++;
            }
            if(O == 3) ret[0] = true;
            else if(X == 3) ret[1] = true;
        }

        int O = 0;
        int X = 0;
        for(int i =0; i<3; i++) {
            if(boardArr[i][i] == 'O') O++;
            else if(boardArr[i][i] == 'X') X++;
        }
        if(O == 3) ret[0] = true;
        else if(X == 3) ret[1] = true;

        O = 0;
        X = 0;
        for(int i =0; i<3; i++) {
            if(boardArr[i][2-i] == 'O') O++;
            else if(boardArr[i][2-i] == 'X') X++;
        }
        if(O == 3) ret[0] = true;
        else if(X == 3) ret[1] = true;

        return ret;
    }

    private char[][] setBoard(String[] board) {
        char[][] boardArr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for(int j =0; j<3; j++) {
             boardArr[i][j] = board[i].charAt(j);
             if(boardArr[i][j] == 'O') OCount++;
             else if(boardArr[i][j] == 'X') XCount++;
             if(boardArr[i][j] != '.') totalCount++;
            }
        }

        return boardArr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] board = {"OXO", "XOX", "OXO"};
        int answer = solution.solution(board);
        System.out.println(answer);
    }
}