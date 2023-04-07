package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_Problem01 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] B = new int[N+1];
		int[] Y = new int[N+1];
		
		B[1] = 1;
		Y[1] = 1;
		for(int i=2;i<=N;i++) {
			B[i] = Y[i-1];
			Y[i] = Y[i-1] + B[i-1];
		}
		System.out.println(B[N]+Y[N]);
	}
}
