import java.io.*;
import java.util.*;

public class WordProcessor {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("word.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		
		int n = readInt(), k = readInt(), cnt = 0;
		String[] arr = readLine().split(" ");
		for (int i = 0; i < n; i ++) {
			String x = arr[i];
			if (cnt + x.length() > k) {
				pw.print("\n" + x);
				cnt = x.length();
				if (i + 1 < n && cnt + arr[i + 1].length() <= k) pw.print(" ");
			}
			else {
				pw.print(x);
				cnt += x.length();
				if (i + 1 < n && cnt + arr[i + 1].length() <= k) pw.print(" ");
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
