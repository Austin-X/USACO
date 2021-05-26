import java.io.*;
import java.util.*;

public class CircularBarn {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("cbarn.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		
		int n = readInt(), tot = 0;
		int[] r = new int[n];
		for (int i = 0; i < n; i ++) { r[i] = readInt(); tot += r[i]; }
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i ++) {
			int temp = 0, cnt = tot;
			cnt -= r[i];
			int j = i + 1;
			if (j == n) j = 0;
			
			while (j != i) {
				temp += cnt;
				cnt -= r[j];
				j ++;
				if (j == n) j = 0;
			}
			ans = Math.min(ans, temp);
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
