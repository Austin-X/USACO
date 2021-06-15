import java.io.*;
import java.util.*;

public class HighCardWins {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("highcard.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		
		int n = readInt(), ans = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 1; i <= 2 * n; i ++) set.add(i);
		
		int[] a = new int[n];
		for (int i = 0; i < n; i ++) {
			a[i] = readInt();
			set.remove(a[i]);
		}
		
		for (int i = 0; i < n; i ++) {
			if (set.higher(a[i]) == null) continue;
			ans ++;
			set.remove(set.higher(a[i]));
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
