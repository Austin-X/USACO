import java.io.*;
import java.util.*;

public class MowingTheField {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("mowing.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
		
		int n = readInt();
		
		int[][] grid = new int[2001][2001];
		int curX = 1000, curY = 1000, time = 1, ans = Integer.MAX_VALUE;
		for (int[] x: grid) Arrays.fill(x, -1);
		grid[1000][1000] = 0;
		
		for (int t = 0; t < n; t ++) {
			char ch = next().charAt(0);
			int s = readInt();
			
			int dirX = 0, dirY = 0;
			if (ch == 'N') dirY = 1;
			else if (ch == 'S') dirY = -1;
			else if (ch == 'W') dirX = -1;
			else dirX = 1;
			
			for (int i = 0; i < s; i ++) {
				curX += dirX;
				curY += dirY;
				if (grid[curX][curY] != -1) ans = Math.min(ans, time - grid[curX][curY]);
				grid[curX][curY] = time;
				time ++;
			}
		}
		
		pw.println(ans == Integer.MAX_VALUE ? -1 : ans);
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
