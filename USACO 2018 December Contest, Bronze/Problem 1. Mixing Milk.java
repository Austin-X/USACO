import java.io.*;
import java.util.*;

public class MixingMilk {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("mixmilk.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		
		int[] c = new int[3], m = new int[3];
		for (int i = 0; i < 3; i ++) {
			c[i] = readInt();
			m[i] = readInt();
		}
		int idx = 0;
		for (int i = 0; i < 100; i ++) {
			if (idx == 2) {
				int amt = Math.min(m[idx], c[0] - m[0]);
				m[idx] -= amt;
				m[0] += amt;
				idx = 0;
			} else {
				int amt = Math.min(m[idx], c[idx + 1] - m[idx + 1]);
				m[idx] -= amt;
				m[idx + 1] += amt;
				idx ++;
			}
		}
		for (int i = 0; i < 3; i ++) pw.println(m[i]);
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
