import java.io.*;
import java.util.*;

public class LemonadeLine {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("lemonade.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		
		int n = readInt();
		Integer[] w = new Integer[n];
		for (int i = 0; i < n; i ++) w[i] = readInt();
		Arrays.parallelSort(w, Collections.reverseOrder());
		int ans = n;
		for (int i = 0; i < n; i ++) if (i > w[i]) { ans = i; break; }
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
