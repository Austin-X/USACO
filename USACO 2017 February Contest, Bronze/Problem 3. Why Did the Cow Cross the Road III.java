import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad_III {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("cowqueue.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		
		int n = readInt(), time = 0;
		int[][] c = new int[n][2];
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i ++) {
			c[i][0] = readInt(); c[i][1] = readInt();
		}
		
		for (int i = 0; i < n; i ++) {
			int min = Integer.MAX_VALUE, minIdx = -1;
			for (int j = 0; j < n; j ++) {
				if (!vis[j] && c[j][0] < min) {
					min = c[j][0]; minIdx = j;
				}
			}
			
			if (time <= min) time = min + c[minIdx][1];
			else time += c[minIdx][1];
			vis[minIdx] = true;
		}
		
		pw.println(time);	
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
