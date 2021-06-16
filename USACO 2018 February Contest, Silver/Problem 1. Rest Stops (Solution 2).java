import java.io.*;
import java.util.*;

public class RestStops {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("reststops.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		
		@SuppressWarnings("unused")
		int l = readInt(), n = readInt(), rf = readInt(), rb = readInt(), mx = 0;
		boolean[] isMax = new boolean[n];
		int[] x = new int[n], c = new int[n];
		long ans = 0;
		
		for (int i = 0; i < n; i ++) {
			x[i] = readInt();
			c[i] = readInt();
		}
		for (int i = n - 1; i >= 0; i --) {
			if (c[i] > mx) {
				mx = c[i];
				isMax[i] = true;
			}
		}

		int cur = 0;
		for (int i = 0; i < n; i ++) {
			if (isMax[i]) {
				long bt = (x[i] - cur) * (long)rb, ft = (x[i] - cur) * (long)rf;
				ans += (ft - bt) * c[i];
				cur = x[i];
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
