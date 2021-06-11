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
			if (x - y == p.x - p.y) return Integer.compare(y, p.y); 
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
		ArrayList<Pair> list = new ArrayList<Pair>();
		
		for (int i = 0; i < n - 1; i ++) {
			Pair p1 = arr[i], p2 = arr[i + 1];
			if (p1.x - p1.y == p2.x - p2.y) continue;
			list.add(p1);
		}
		list.add(arr[n - 1]);
		
		max = list.get(0).x + list.get(0).y;
		for (int i = 1; i < list.size(); i ++) {
			Pair p = list.get(i);
			if (max < p.x + p.y) { ans ++; max = p.x + p.y; }
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
