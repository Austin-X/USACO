import java.io.*;
import java.util.*;

public class FieldReduction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	static class Pair1 implements Comparable<Pair1> {
		int x, y;
		Pair1 (int x, int y) { this.x = x; this.y = y; }
		public int compareTo (Pair1 p) { return Integer.compare(x, p.x); }
		public boolean equals (Object o) { 
			Pair1 p = (Pair1) o;
			return x == p.x && y == p.y; 
		}
		public String toString() { return x + " " + y; }
	}
	
	static class Pair2 implements Comparable<Pair2> {
		int x, y;
		Pair2 (int x, int y) { this.x = x; this.y = y; }
		public int compareTo (Pair2 p) { return Integer.compare(y, p.y); }
	}
	
	static ArrayList<Pair1> vis = new ArrayList<Pair1>();
	static int ans = 0, n;
	static Pair1[] arr1;
	static Pair2[] arr2;
	static ArrayList<Pair1> p;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("reduce.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		
		n = readInt();
		arr1 = new Pair1[n];
		arr2 = new Pair2[n];
		int minX = Integer.MAX_VALUE, maxX = 0, minY = Integer.MAX_VALUE, maxY = 0;
		for (int i = 0; i < n; i ++) {
			int x = readInt(), y = readInt();
			arr1[i] = new Pair1(x, y); arr2[i] = new Pair2(x, y);
			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}
		ans = (maxX - minX) * (maxY - minY);
		Arrays.parallelSort(arr1); Arrays.parallelSort(arr2);

		p = new ArrayList<Pair1>();
		if (arr1[3].x != arr1[0].x) for (int i = 0; i < 3; i ++) p.add(arr1[i]);
		if (arr1[n - 4].x != arr1[n - 1].x) for (int i = n - 3; i <= n - 1; i ++) if (!p.contains(arr1[i])) p.add(arr1[i]);
		if (arr2[3].y != arr2[0].y) for (int i = 0; i < 3; i ++) if (!p.contains(new Pair1(arr2[i].x, arr2[i].y))) p.add(new Pair1(arr2[i].x, arr2[i].y));
		if (arr2[n - 4].y != arr2[n - 1].y) for (int i = n - 3; i <= n - 1; i ++) if (!p.contains(new Pair1(arr2[i].x, arr2[i].y))) p.add(new Pair1(arr2[i].x, arr2[i].y));
		solve(0);
		pw.println(ans);
		pw.close();
	}

	static void solve(int cnt) {
		if (cnt == 3) {
			int minX = Integer.MAX_VALUE, maxX = 0, minY = Integer.MAX_VALUE, maxY = 0;
			for (int i = 0; i < n; i ++) {
				if (!vis.contains(arr1[i])) {
					minX = Math.min(minX, arr1[i].x);
					maxX = Math.max(maxX, arr1[i].x);
					minY = Math.min(minY, arr1[i].y);
					maxY = Math.max(maxY, arr1[i].y);
				}
			}
			ans = Math.min(ans, (maxX - minX) * (maxY - minY));
			return;
		}
		for (int i = 0; i < p.size(); i ++) {
			if (!vis.contains(p.get(i))) {
				vis.add(p.get(i));
				solve(cnt + 1);
				vis.remove(vis.size() - 1);
			}
 		}
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
