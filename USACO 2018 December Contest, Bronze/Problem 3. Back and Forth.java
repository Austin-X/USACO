import java.io.*;
import java.util.*;

public class BackAndForth {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	static int[] a, b;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("backforth.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		
		a = new int[10]; b = new int[10];
		for (int i = 0; i < 10; i ++) a[i] = readInt();
		for (int i = 0; i < 10; i ++) b[i] = readInt();
		solve(0, 0, 1000, 1000);
		
		pw.println(ans.size());
		pw.close();
	}
	
	static void solve(int idx, int extra, int first, int second) {
		if (idx == 4) {
			if (!ans.contains(first)) ans.add(first);
			return;
		}
		
		for (int i = 0; i < 10; i ++) {
			if (idx % 2 == 0) {
				if (a[i] != 0) {
					int temp = a[i];
					a[i] = 0;
					solve(idx + 1, temp, first - temp, second + temp);
					a[i] = temp;
				}
			} else {
				if (b[i] != 0) {
					int temp = b[i];
					b[i] = 0;
					solve(idx + 1, temp, first + temp, second - temp);
					b[i] = temp;
				}
			}
		}
		
		if (extra != 0) {
			if (idx % 2 == 0) solve(idx + 1, extra, first - extra, second + extra);
			else solve(idx + 1, extra, first + extra, second - extra);
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
