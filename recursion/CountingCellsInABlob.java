package recursion;

public class CountingCellsInABlob {

    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR = 1;
    private static int ALREADY_COUNTED = 2;
    private static final int N = 8;

    private static int[][] grid = {
            {1,0,0,0,0,0,0,1},
            {0,1,1,0,0,1,0,0},
            {1,1,0,0,1,0,1,0},
            {0,0,0,0,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {1,0,0,0,1,0,0,1},
            {0,1,1,0,0,1,1,1}
    };
    public static void main(String[] args) {
        System.out.println(countCells(5,3));
    }

    public static int countCells(int x, int y){
        if(x<0||y<0||x>=N||y>=N) //이탈할 경우에
            return 0;
        else if(grid[x][y] != IMAGE_COLOR) //색이 칠해진 곳이 아닐 경우
            return 0;
        else{
            grid[x][y] =ALREADY_COUNTED; // 이미 지나온 곳으로 체크
            return 1+countCells(x-1,y)+countCells(x+1,y)+countCells(x-1,y-1)
                    +countCells(x-1,y+1)+countCells(x+1,y-1)+countCells(x+1,y+1)
                    +countCells(x,y+1)+countCells(x,y-1);
        }
    }
}
