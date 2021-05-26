import java.io.*;
import java.util.*;

public class Photoshoot {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("photo.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		
		int n = readInt();
		int[] b = new int[n];
		for (int i = 0; i < n - 1; i ++) b[i] = readInt();
		for (int i = 1; i < b[0] && i <= n; i ++) {
			boolean[] vis = new boolean[n + 1];
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(i);
			vis[i] = true; 
			for (int j = 0; j < n - 1; j ++) {
				int val = b[j] - ans.get(ans.size() - 1);
				if (val < 1 || val > n || vis[val]) break;
				vis[val] = true;
				ans.add(val);
			}
			if (ans.size() == n) {
				for (int j = 0; j < ans.size() - 1; j ++) pw.print(ans.get(j) + " ");
				pw.println(ans.get(ans.size() - 1));
				break;
			}
		}
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
