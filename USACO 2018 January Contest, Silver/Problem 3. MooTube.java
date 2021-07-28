import java.io.*;
import java.util.*;

public class MooTube {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static class Edge {
		int dest, rel;
		Edge (int dest, int rel) { this.dest = dest; this.rel = rel; }
	}
	
	static int ans;
	static boolean[] vis;
	static ArrayList<Edge>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("mootube.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		
		int n = readInt(), q = readInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Edge>();
		for (int i = 0; i < n - 1; i ++) {
			int x = readInt(), y = readInt(), r = readInt();
			adj[x].add(new Edge(y, r));
			adj[y].add(new Edge(x, r));
		}
		
		while (q-- > 0) {
			int k = readInt(), v = readInt();
			vis = new boolean[n + 1];
			ans = 0;
			dfs(v, k, Integer.MAX_VALUE);
			pw.println(ans);
		}
		pw.close();
	}
	
	static void dfs(int u, int k, int val) {
		vis[u] = true;
		for (Edge x: adj[u]) {
			if (!vis[x.dest]) {
				if (Math.min(val, x.rel) >= k) {
					ans ++;
					dfs(x.dest, k, Math.min(val, x.rel));
				}
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
