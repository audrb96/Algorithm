import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class solution3 {
    int[] dx = {0,-1,0,1};
    int[] dy = {1,0,-1,0};
    public String[] solution(int[][] macaron) {
        int[][] board = new int[6][6];
        String[] answer = new String[6];

        for(int i =0; i<macaron.length; i++) {
            int col = macaron[i][0]-1;
            int color = macaron[i][1];
            for(int j =5; j>=0 ; j--) {
                if(board[j][col] == 0) {
                    board[j][col] = color;
                    break;
                }
            }
            boolean isPop = false;
            while (!isPop) {
                isPop = !pop(board);
                down(board);
            }
        }

        for(int i = 0;i<6;i++) {
            String temp = "";
            for (int j=0;j<6;j++) {
                temp += Integer.toString(board[i][j]);
            }
            answer[i] = temp;
        }
        return answer;
    }

    public void down(int[][] board) {

        for(int i = 4; i>=0; i--) {
            for(int j = 5; j>=0;j--) {
                int count = 1;
                while (i+count <= 5 && board[i+count-1][j] != 0&& board[i+count][j] == 0 ) {
                    int temp = board[i+count-1][j];
                    board[i+count][j] = temp;
                    board[i+count-1][j] = 0;
                    count++;
                }
            }
        }
    }

    public boolean pop(int[][] board) {
        boolean[][] isVisited = new boolean[6][6];
        boolean isPop = false;

        for(int i =0; i<6; i++) {
            for(int j=0 ;j<6 ;j++) {
                if (isVisited[i][j] || board[i][j] == 0) continue;
                Queue<int[]> queue = new LinkedList<>();
                ArrayList<int[]> popList = new ArrayList<>();
                int count = 0;
                int color = board[i][j];
                queue.add(new int[]{i, j});
                popList.add(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] temp = queue.poll();
                    isVisited[temp[0]][temp[1]] = true;
                    count++;
                    for (int d = 0; d < 4; d++) {
                        int nx = temp[1] + dx[d];
                        int ny = temp[0] + dy[d];
                        if (nx > 5 || nx < 0 || ny > 5 || ny < 0) continue;
                        if (isVisited[ny][nx]) continue;
                        if (board[ny][nx] != color || board[ny][nx] == 0) continue;
                        queue.add(new int[]{ny, nx});
                        popList.add(new int[]{ny,nx});
                    }
                }
                if(count >= 3) {
                    for(int k =0 ; k<popList.size();k++) {
                        int[] popIndex = popList.get(k);
                        board[popIndex[0]][popIndex[1]] = 0;
                    }
                    isPop = true;
                }
            }
        }
        return isPop;
    }




    public static void main(String[] args) {
        solution3 solution = new solution3();
        int[][] macaron = {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4}, {4,3},{5,4},{6,1}};
        String[] solution1 = solution.solution(macaron);
        for (String i : solution1) {
            System.out.println(i);
        }
    }
}
