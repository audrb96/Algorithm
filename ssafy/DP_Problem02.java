package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP_Problem02 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+1];
		DP[1] = 2;
		DP[2] = 5;
		for(int i=3;i<=N;i++) {
			DP[i] = DP[i-2] + DP[i-1]*2;
		}
		System.out.println(Arrays.toString(DP));
		
		//DP[N] = (마지막에 빨강)DP[N-2] + (마지막에 파랑 또는 노랑)DP[n-1]*2;
		//DP[3] = DP[1] + DP[2] *2;
		//DP[1] + 빨강, 빨강 + (노랑 또는 파랑)
		//DP[1] + 노랑노랑, DP[1] + 노랑 파랑

	}

}
