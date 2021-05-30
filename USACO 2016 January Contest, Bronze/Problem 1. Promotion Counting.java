import java.io.*;
import java.util.*;

public class PromotionCounting {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("promote.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
		
		int b1 = readInt(), b2 = readInt(), s1 = readInt(), s2 = readInt(), g1 = readInt(), g2 = readInt(), p1 = readInt(), p2 = readInt();
		pw.println((s2 - s1) + (g2 - g1) + (p2 - p1));
		pw.println((g2 - g1) + (p2 - p1));
		pw.println(p2 - p1);
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
