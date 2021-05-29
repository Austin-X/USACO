import java.io.*;
import java.util.*;

public class BlockedBillboard_II {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("billboard.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		int x3 = readInt(), y3 = readInt(), x4 = readInt(), y4 = readInt();
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		
		if (x3 >= x1 && y3 >= y1 && x4 <= x2 && y4 <= y2) pw.println(0);
		else if (x3 < x1 && y3 >= y1 && x4 <= x2 && y4 <= y2) pw.println((x1 - x3) * (y4 - y3));
		else if (x3 >= x1 && x4 > x2 && y3 >= y1 && y4 <= y2) pw.println((x4 - x2) * (y4 - y3));
		else if (x3 >= x1 && x4 <= x2 && y3 < y1 && y4 <= y2) pw.println((x4 - x3) * (y1 - y3));
		else if (x3 >= x1 && x4 <= x2 && y3 >= y1 && y4 > y2) pw.println((x4 - x3) * (y4 - y2));
		else pw.println((x4 - x3) * (y4 - y3));
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
