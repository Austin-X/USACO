import java.io.*;
import java.util.*;

public class Moocast {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw;
	
	static boolean[] vis;
	static ArrayList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("moocast.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		
		int n = readInt(), ans = 1;
		int[] x = new int[n], y = new int[n], p = new int[n];
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i ++) adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < n; i ++) { x[i] = readInt(); y[i] = readInt(); p[i] = readInt(); }
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				if (i == j) continue;
				if (Math.ceil(Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]))) <= p[i]) adj[i + 1].add(j + 1);
			}
		}
		
		for (int i = 1; i <= n; i ++) {
			vis = new boolean[n + 1];
			dfs(i);
			int cnt = 0;
			for (int j = 1; j <= n; j ++) if (vis[j]) cnt ++;
			ans = Math.max(ans, cnt);
		}
		pw.println(ans);
		pw.close();
	}

	static void dfs (int u) {
		vis[u] = true;
		for (int x: adj[u]) if (!vis[x]) dfs(x);
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
