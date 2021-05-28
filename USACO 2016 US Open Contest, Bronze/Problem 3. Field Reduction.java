import java.io.*;
import java.util.*;

public class FieldReduction {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("reduce.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		
		int n = readInt(), minX = Integer.MAX_VALUE, maxX = 0, minY = Integer.MAX_VALUE, maxY = 0, ans = Integer.MAX_VALUE;
		int[] x = new int[n], y= new int[n];
		for (int i = 0; i < n; i ++) { 
			x[i] = readInt(); y[i] = readInt(); 
			minX = Math.min(minX, x[i]);
			maxX = Math.max(maxX, x[i]);
			minY = Math.min(minY, y[i]);
			maxY = Math.max(maxY, y[i]);
		}
		
		for (int i = 0; i < n; i ++) {
			if (x[i] == minX || x[i] == maxX || y[i] == minY || y[i] == maxY) {
				int tempMinX = Integer.MAX_VALUE, tempMaxX = 0, tempMinY = Integer.MAX_VALUE, tempMaxY = 0;
				for (int j = 0; j < n; j ++) {
					if (j != i) {
						tempMinX = Math.min(tempMinX, x[j]);
						tempMaxX = Math.max(tempMaxX, x[j]);
						tempMinY = Math.min(tempMinY, y[j]);
						tempMaxY = Math.max(tempMaxY, y[j]);
					}
				}
				ans = Math.min(ans, (tempMaxX - tempMinX) * (tempMaxY - tempMinY));
				if (x[i] == minX) minX = -1;
				else if (x[i] == maxX) maxX = -1;
				else if (y[i] == minY) minY = -1;
				else if (y[i] == maxY) maxY = -1;
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
