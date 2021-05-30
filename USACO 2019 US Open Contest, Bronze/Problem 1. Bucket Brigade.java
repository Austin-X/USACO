import java.io.*;
import java.util.*;

public class BucketBrigade {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("buckets.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		
		int br = 0, bc = 0, lr = 0, lc = 0, rr = 0, rc = 0;
		for (int i = 0; i < 10; i ++) {
			char[] ch = readLine().toCharArray();
			for (int j = 0; j < 10; j ++) {
				if (ch[j] == 'B') { br = i; bc = j; }
				else if (ch[j] == 'L') { lr = i; lc = j; }
				else if (ch[j] == 'R') { rr = i; rc = j; }
			}
		}
		if (bc == lc && bc == rc && (rr > br && rr < lr || rr > lr && rr < br)) pw.println(Math.abs(br - lr) + 1);
		else if (br == lr && br == rr && (rc > bc && rc < lc || rc > lc && rc < bc)) pw.println(Math.abs(bc - lc) + 1);
		else pw.println(Math.abs(br - lr) + Math.abs(bc - lc) - 1);
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
