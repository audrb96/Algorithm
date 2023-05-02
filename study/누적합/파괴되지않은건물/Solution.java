package study.누적합.파괴되지않은건물;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] temp = new int[board.length+1][board[0].length+1];

        for(int i =0; i<skill.length; i++) {
            int[] oneSkill = skill[i];
            int degree = oneSkill[0] == 1 ? -oneSkill[5] : oneSkill[5];
            processSkill(temp, oneSkill[1], oneSkill[2], oneSkill[3], oneSkill[4], degree);
        }

        processTemp(temp);
        answer = sumAndCount(temp, board);

        return answer;
    }

    private int sumAndCount(int[][] temp, int[][] board) {
        int count = 0;

        for(int i =0; i<board.length; i++) {
            for(int j =0; j<board[i].length; j++) {
                board[i][j] += temp[i][j];
                if(board[i][j] > 0) count++;
            }
        }
        return count;
    }

    private void processTemp(int[][] temp) {
        for(int i =0; i<temp.length; i++) {
            for(int j=1; j<temp[i].length; j++) {
                temp[i][j] += temp[i][j-1];
            }
        }
        for(int i =0; i<temp[0].length;i++) {
            for(int j =1; j<temp.length;j++) {
                temp[j][i] += temp[j-1][i];
            }
        }
    }

    private void processSkill(int[][] temp, int r1, int c1, int r2, int c2, int degree) {
        temp[r1][c1] += degree;
        temp[r1][c2+1] -= degree;
        temp[r2+1][c1] -= degree;
        temp[r2+1][c2+1] += degree;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
//        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};

        int answer = solution.solution(board, skill);
        System.out.println(answer);
    }
}