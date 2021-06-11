import java.io.*;
import java.util.*;

public class MountainView {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		Pair (int x, int y) { this.x = x; this.y = y; }
		public int compareTo(Pair p) { 
			if (x - y == p.x - p.y) return -Integer.compare(y, p.y); 
			return Integer.compare(x - y, p.x - p.y); 
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("mountains.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		
		int n = readInt(), ans = 1, max = 0;
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i ++) arr[i] = new Pair(readInt(), readInt());
		Arrays.parallelSort(arr);
		max = arr[0].x + arr[0].y;
		for (int i = 1; i < n; i ++) if (max < arr[i].x + arr[i].y) { ans ++; max = arr[i].x + arr[i].y; }
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
