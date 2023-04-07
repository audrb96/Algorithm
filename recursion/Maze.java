package recursion;

public class Maze {
    private static final int N = 8;
    private static int [][] maze = {
            {0,0,0,0,0,0,0,1},
            {0,1,1,0,1,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,0,0,1,1,0,0},
            {0,1,1,1,0,0,1,1},
            {0,1,0,0,0,1,0,1},
            {0,0,0,1,0,0,0,1},
            {0,1,1,1,0,1,0,0}
    };

    private static final int PATHWAY_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;

    public static void main(String[] args) {
        System.out.println(findMazePath(0,0));

    }

    public static boolean findMazePath(int x,int y){
        if(x<0||y<0||x>=N||y>=N||maze[x][y] != PATHWAY_COLOR){
            return false;
        } //현재 위치가 벽이거나 x,y 위치가 이탈할때 false 출력
        else if(x==N-1 && y==N-1){
            maze[x][y]=PATH_COLOR;
            return true;
        } // 도착했을때 true
        else{
            maze[x][y] = PATH_COLOR;
            if(findMazePath(x+1,y)||findMazePath(x-1,y)||findMazePath(x,y+1)||findMazePath(x,y-1))
                return true;
        }//4방향 중에 갈 곳이 있을 때
        maze[x][y]=BLOCKED_COLOR; //4방향 중에 갈 곳이 없을 때
        return false;
    }
}
