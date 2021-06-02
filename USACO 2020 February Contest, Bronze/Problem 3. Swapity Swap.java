import java.io.*;
import java.util.*;

public class SwapitySwap {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("swap.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		
		int n = readInt(), k = readInt(), a1 = readInt(), a2 = readInt(), b1 = readInt(), b2 = readInt();
		int[] ans = new int[n + 1];
		for (int i = 1; i <= n; i ++) ans[i] = i;
		for (int i = 1; i <= n; i ++) {
			if ((i < a1 || i > a2) && (i < b1 || i > b2)) continue;
			int[] times = new int[n + 1];
			Arrays.fill(times, -1); times[i] = 0;
			int cur = i, cnt = 0;
			while (true) {
				if (cur >= a1 && cur <= a2) cur = fun(n, a1, a2, cur);
				if (cur >= b1 && cur <= b2) cur = fun(n, b1, b2, cur);
				cnt ++;
				if (cnt == k) {
					ans[cur] = i;
					break;
				}
				if (times[cur] != -1) {
					int diff = cnt - times[cur], val = k - (k - times[cur]) / diff * diff;
					for (int j = 1; j <= val; j ++) {
						if (cur >= a1 && cur <= a2) cur = fun(n, a1, a2, cur);
						if (cur >= b1 && cur <= b2) cur = fun(n, b1, b2, cur);
					}
					ans[cur] = i;
					break;
				}
			}
		}
		for (int i = 1; i <= n; i ++) pw.println(ans[i]);
		pw.close();
	}
	
	static int fun (int n, int a1, int a2, int cur) {
		if (cur >= a1 && cur <= a2) cur = a2 - (cur - a1);
		return cur;
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
