import java.util.ArrayList;

public class Solution2 {
    public static int[][] solution(int n,boolean clockwise) {
        int[][] ans = new int[n][n];
        if(clockwise){
            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            int[][] evenEnd = {{n/2,n/2},{n/2+1,n/2},{n/2+1,n/2+1},{n/2,n/2+1}};
            int[] oddEnd = {n/2,n/2};
            int d = 0;
            int[][] start = {{0,0},{n-1,0},{n-1,n-1},{0,n-1}};
            int k =0;
            int x = start[k][0];
            int y = start[k][1];
            int end = n-1;
            int i =1;
            int p =1;
            while (true){
                ans[y][x] = i;
                if(isEnd(ans,n)) break;
                if(n%2==0){
                    boolean temp = false;
                    for(int j=0;j<evenEnd.length;j++){
                        if(x==evenEnd[j][0]&&y==evenEnd[j][1]){
                            temp = true;
                        }
                    }
                    if(temp){
                        k++;
                        i=1;
                        d=0;
                        end=n-1;
                        p=1;
                        if(k>=4) break;
                        x= start[k][0];
                        y = start[k][1];
                        continue;
                    };
                }
                if(n%2==1&&x==oddEnd[0]&&y==oddEnd[1]){
                    k++;
                    i=1;
                    d=0;
                    end=n-1;
                    p=1;
                    if(k>=4) break;
                    x= start[k][0];
                    y = start[k][1];
                    continue;
                }

                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx>n-1||ny>n-1||ans[ny][nx] != 0){
                    while (true){
                        d++;
                        if(d>3) d=0;
                        nx = x+dx[d];
                        ny = y+dy[d];
                        if(nx>n-1||ny>n-1||nx<0||ny<0||ans[ny][nx] != 0) continue;
                        x = nx;
                        y = ny;
                        break;
                    }
                    i++;
                    p=2;
                    continue;
                }

                if(p==end){
                    d++;
                    if(d>3) d=0;
                    end= end-1;
                    x = x+dx[d];
                    y = y+dy[d];
                    i++;
                    p=2;
                    continue;
                }
                x = nx;
                y = ny;
                i++;
                p++;
            }
        } else{
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            int[][] evenEnd = {{n/2,n/2},{n/2+1,n/2},{n/2+1,n/2+1},{n/2,n/2+1}};
            int[] oddEnd = {n/2,n/2};
            int d = 0;
            int[][] start = {{0,0},{n-1,0},{n-1,n-1},{0,n-1}};
            int k =0;
            int x = start[k][0];
            int y = start[k][1];
            int end = n-1;
            int i =1;
            int p =1;
            while (true){
                ans[y][x] = i;
                if(isEnd(ans,n)) break;
                if(n%2==0){
                    boolean temp = false;
                    for(int j=0;j<evenEnd.length;j++){
                        if(x==evenEnd[j][0]&&y==evenEnd[j][1]){
                            temp = true;
                        }
                    }
                    if(temp){
                        k++;
                        i=1;
                        d=0;
                        end=n-1;
                        p=1;
                        if(k>=4) break;
                        x= start[k][0];
                        y = start[k][1];
                        continue;
                    };
                }
                if(n%2==1&&x==oddEnd[0]&&y==oddEnd[1]){
                    k++;
                    i=1;
                    d=0;
                    end=n-1;
                    p=1;
                    if(k>=4) break;
                    x= start[k][0];
                    y = start[k][1];
                    continue;
                }

                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx>n-1||ny>n-1||nx<0||ny<0||ans[ny][nx] != 0){
                    while (true){
                        d++;
                        if(d>3) d=0;
                        nx = x+dx[d];
                        ny = y+dy[d];
                        if(nx==oddEnd[0] && ny == oddEnd[1]) {
                            x=nx;
                            y=nx;
                            break;
                        }
                        if(nx>n-1||ny>n-1||nx<0||ny<0||ans[ny][nx] != 0) continue;
                        x = nx;
                        y = ny;
                        break;
                    }
                    i++;
                    p=2;
                    continue;
                }

                if(p==end){
                    d++;
                    if(d>3) d=0;
                    end= end-1;
                    x = x+dx[d];
                    y = y+dy[d];
                    i++;
                    p=2;
                    continue;
                }
                x = nx;
                y = ny;
                i++;
                p++;
            }
        }

        return ans;
    }

    public static boolean isEnd(int[][] arr,int n){
        boolean ret = true;
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0) ret = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] ans = solution(5,false);
        for(int i =0;i<5;i++){
            for(int j =0;j<5;j++){
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }
    }
}
