import java.io.*;
import java.util.*;

public class Triangles {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("triangles.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		
		int n = readInt(), ans = 0;
		int[] x = new int[n], y = new int[n];
		for (int i = 0; i < n; i ++) { x[i] = readInt(); y[i] = readInt(); }
		for (int i = 0; i < n; i ++) {
			for (int j = i + 1; j < n; j ++) {
				for (int k = j + 1; k < n; k ++) {
					if (x[i] == x[j] && y[j] == y[k]) ans = Math.max(ans, calcDis(y[i], y[j], x[k], x[i]));
					else if (x[i] == x[j] && y[i] == y[k]) ans = Math.max(ans, calcDis(y[j], y[i], x[k], x[i]));
					else if (x[i] == x[k] && y[j] == y[k]) ans = Math.max(ans, calcDis(y[i], y[k], x[k], x[j]));
					else if (x[i] == x[k] && y[j] == y[i]) ans = Math.max(ans, calcDis(y[i], y[k], x[j], x[i]));
					else if (x[j] == x[k] && y[i] == y[k]) ans = Math.max(ans, calcDis(y[j], y[k], x[i], x[k]));
					else if (x[j] == x[k] && y[i] == y[j]) ans = Math.max(ans, calcDis(y[j], y[k], x[i], x[j]));
				}
			}
		}
		
		pw.println(ans);
		pw.close();
	}
	
	static int calcDis(int a, int b, int c, int d) {
		return Math.abs(a - b) * Math.abs(c - d);
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
