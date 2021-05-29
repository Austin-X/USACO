import java.awt.*;
import java.io.*;
import java.util.*;

public class BlockedBillboard {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("billboard.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		Rectangle rect1 = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt();
		Rectangle rect2 = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt();
		Rectangle rect3 = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		
		Rectangle r1 = rect1.intersection(rect3), r2 = rect2.intersection(rect3);
		int ans = rect1.height * rect1.width + rect2.height * rect2.width;
		if (r1.width > 0 && r1.height > 0) ans -= r1.height * r1.width;
		if (r2.width > 0 && r2.height > 0) ans -= r2.height * r2.width;
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
