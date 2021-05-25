import java.io.*;
import java.util.*;

public class TheLostCow {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("lostcow.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		
		int x = readInt(), y = readInt();
		
		int cur = 1, dis = 0, pos = x;
		boolean right = true;
		
		while (x != y) {
			if (right) {
				if (x < y && x + cur >= y) {
					dis += y - pos;
					break;
				} else {
					dis += x - pos + cur;
					pos = x + cur;
					cur *= 2;
					right = false;
				}
			} else {
				if (x > y && x - cur <= y) {
					dis += pos - y;
					break;
				} else {
					dis += pos - x + cur;
					pos = x - cur;
					cur *= 2;
					right = true;
				}
			}
		}
		
		pw.println(dis);
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
