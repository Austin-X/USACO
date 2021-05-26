import java.io.*;
import java.util.*;

public class CowGymnastics {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("gymnastics.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		
		int k = readInt(), n = readInt();
		int[][] arr = new int[k][n + 1];
		for (int i = 0; i < k; i ++) 
			for (int j = 1; j <= n; j ++) arr[i][readInt()] = j;
		int ans = 0;
		for (int i = 1; i <= n; i ++) {
			for (int j = i + 1; j <= n; j ++) {
				boolean flag = true;
				if (arr[0][i] < arr[0][j]) {
					for (int p = 1; p < k; p ++) {
						if (arr[p][i] > arr[p][j]) {
							flag = false;
							break;
						}
					}
				} else {
					for (int p = 1; p < k; p ++) {
						if (arr[p][i] < arr[p][j]) {
							flag = false;
							break;
						}
 					}
				}
				if (flag) ans ++;
			}
		}
		
		pw.println(ans);
		pw.close();
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
