import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static class Pair1 implements Comparable<Pair1> {
		int a, b;
		Pair1 (int a, int b) { this.a = a; this.b = b; }
		public int compareTo(Pair1 p) { return Integer.compare(a, p.a); }
	}
	
	static class Pair2 implements Comparable<Pair2> {
		int a, b;
		Pair2 (int a, int b) { this.a = a; this.b = b; }
		public int compareTo(Pair2 p) {  return Integer.compare(b, p.b); }
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("helpcross.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		
		int c = readInt(), n = readInt(), ans = 0;
		int[] chickens = new int[c];
		TreeMap<Pair2, Integer> map = new TreeMap<Pair2, Integer>();
		
		for (int i = 0; i < c; i ++) chickens[i] = readInt();
		Pair1[] temp = new Pair1[n];
		Arrays.parallelSort(chickens);
		for (int i = 0; i < n; i ++) {
			int a = readInt(), b = readInt();
			temp[i] = new Pair1(a, b);
		}
		Arrays.parallelSort(temp);
		
		for (int i = 0, j = 0; i < c; i ++) {
			while (j < n && chickens[i] >= temp[j].a) {
				Pair2 p = new Pair2(temp[j].a, temp[j].b);
				map.putIfAbsent(p, 0);
				map.put(p, map.get(p) + 1);
				j ++; 
			}
			while (!map.isEmpty() && chickens[i] > map.firstKey().b) map.remove(map.firstKey());
			if (!map.isEmpty()) { 
				Pair2 p = map.firstKey();
				map.put(p, map.get(p) - 1);
				if (map.get(p) == 0) map.remove(p);
				ans ++; 
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
