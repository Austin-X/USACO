import java.io.*;
import java.util.*;

public class Lifeguards {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("lifeguards.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		int n = readInt(), ans = 0;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i ++) { arr[i][0] = readInt(); arr[i][1] = readInt(); }
		for (int i = 0; i < n; i ++) {
			int[] pfs = new int[1002];
			for (int j = 0; j < n; j ++) {
				if (j == i) continue;
				pfs[arr[j][0]] ++; pfs[arr[j][1]] --;
			}
			int temp = 0;
			for (int j = 1; j <= 1000; j ++) { pfs[j] += pfs[j - 1]; temp += pfs[j] > 0 ? 1 : 0; }
			ans = Math.max(ans, temp);
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
