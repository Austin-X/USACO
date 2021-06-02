import java.io.*;
import java.util.*;

public class Teleportation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("teleport.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		
		int a = readInt(), b = readInt(), x = readInt(), y = readInt();
		pw.println(Math.min(Math.abs(b - a), Math.min(Math.abs(a - x) + Math.abs(b - y), Math.abs(a - y) + Math.abs(b - x))));
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
