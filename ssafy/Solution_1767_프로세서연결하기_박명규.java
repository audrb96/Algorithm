package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_박명규 {
	static int[][] map;
	static ArrayList<int[]> core;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans;
	static int max;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			core = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != N-1 && j != N-1 && i != 0 && j != 0 && map[i][j] == 1) {
						core.add(new int[] {i,j});
					}
				}
			}
			max = 0;
			ans = Integer.MAX_VALUE;
			dfs(0,0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int cnt,int coreLinked, int sum) {
		if(cnt == core.size()) {
			if(max<coreLinked) {
				max = coreLinked;
				ans = sum;
			}
			else if(max == coreLinked) {
				ans = Integer.min(ans,sum);
			}
			return;
		}
		int x,y;
		x = core.get(cnt)[0];
		y=  core.get(cnt)[1];

		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;
			int len = 0;
			while (true){
				nx += dx[i];
				ny += dy[i];
				if(nx<0 || ny<0||nx == N || ny == N){
					break;
				}
				if(map[nx][ny] == 1) {
					len = 0;
					break;
				}
				len ++;
			}
			nx = x;
			ny = y;
			for(int j =0;j<len;j++){
				nx += dx[i];
				ny += dy[i];
				map[nx][ny] = 1;
			}
			if(len == 0 ){
				dfs(cnt+1,coreLinked,sum);
			} else {
				dfs(cnt+1,coreLinked+1,sum+len);
				nx =x;
				ny = y;
				for(int j =0;j<len;j++){
					nx += dx[i];
					ny += dy[i];
					map[nx][ny] = 0;
				}
			}
		}
	}

}
