import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static class Pair implements Comparable<Pair> {
		int a, b;
		Pair (int a, int b) { this.a = a; this.b = b; }
		public int compareTo(Pair p) { return Integer.compare(b, p.b); }
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("helpcross.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		
		int c = readInt(), n = readInt(), ans = 0;
		TreeMap<Integer, Integer> chickens = new TreeMap<Integer, Integer>();
		Pair[] cows = new Pair[n];
		
		for (int i = 0; i < c; i ++) {
			int x = readInt();
			chickens.putIfAbsent(x, 0);
			chickens.put(x, chickens.get(x) + 1);
		}
		for (int i = 0; i < n; i ++) cows[i] = new Pair(readInt(), readInt());
		Arrays.parallelSort(cows);
		
		for (int i = 0; i < n; i ++) {
			if (chickens.ceilingKey(cows[i].a) == null) continue;
			int x = chickens.ceilingKey(cows[i].a);
			if (x > cows[i].b) continue;
			chickens.put(x, chickens.get(x) - 1);
			if (chickens.get(x) == 0) chickens.remove(x);
			ans ++;
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
