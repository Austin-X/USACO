import java.io.*;
import java.util.*;

public class Hoofball {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("hoofball.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		
		int n = readInt(), ans = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i ++) adj[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i ++) {
			boolean[] vis = new boolean[n];
			vis[i] = true;
			int idx = i;
			while (true) {
				int min = Integer.MAX_VALUE, minIdx = -1;
				for (int j = 0; j < n; j ++) {
					if (j != idx && (Math.abs(arr[j] - arr[idx]) < min || Math.abs(arr[j] - arr[idx]) == min && arr[j] < arr[idx])) {
						min = Math.abs(arr[j] - arr[idx]);
						minIdx = j;
					}
				}
				if (vis[minIdx]) break;
				vis[minIdx] = true;
				adj[i].add(minIdx);
				idx = minIdx;
			}
		}
		
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i ++) {
			if (vis[i]) continue;
			int best = 0, bestIdx = i;
			for (int j = 0; j < n; j ++) {
				if (j == i || adj[j].contains(i)) {
					if (adj[j].size() > best) {
						best = adj[j].size();
						bestIdx = j;
					}
				}
			}
			for (int x: adj[bestIdx]) vis[x] = true;
			vis[bestIdx] = true;
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
