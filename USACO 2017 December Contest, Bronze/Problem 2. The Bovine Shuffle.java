import java.io.*;
import java.util.*;

public class TheBovineShuffle {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("shuffle.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		
		int n = readInt();
		int[] c = new int[n + 1], id = new int[n + 1];
		for (int i = 1; i <= n; i ++) c[i] = readInt();
		for (int i = 1; i <= n; i ++) id[i] = readInt();
		
		for (int i = 0; i < 3; i ++) {
			int[] temp = new int[n + 1];
			for (int j = 1; j <= n; j ++) temp[j] = id[c[j]];
			id = Arrays.copyOf(temp, n + 1);
		}
		for (int i = 1; i <= n; i ++) pw.println(id[i]);
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
