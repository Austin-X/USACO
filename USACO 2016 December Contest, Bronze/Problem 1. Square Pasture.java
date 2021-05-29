import java.io.*;
import java.util.*;

public class SquarePasture {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("square.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		int x3 = readInt(), y3 = readInt(), x4 = readInt(), y4 = readInt();
		int maxX = Math.max(x2, x4), minX = Math.min(x1, x3), maxY = Math.max(y2, y4), minY = Math.min(y1, y3);
		int diff = Math.max(maxX - minX, maxY - minY);
		pw.println(diff * diff);	
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
