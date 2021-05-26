import java.io.*;
import java.util.*;

public class MilkPails {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("pails.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		
		int x = readInt(), y = readInt(), m = readInt();
		boolean[] vis = new boolean[m + 1];
		vis[0] = true;
		int cur = x;
		while (cur <= m) {
			vis[cur] = true;
			cur += x;
		}
		cur = 0;
		while (cur <= m) {
			if (vis[cur] && cur + y <= m) vis[cur + y] = true;
			cur ++;
		}
		
		int ans = 0;
		for (int i = y; i <= m; i ++) if (vis[i]) ans = Math.max(ans, i);
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
