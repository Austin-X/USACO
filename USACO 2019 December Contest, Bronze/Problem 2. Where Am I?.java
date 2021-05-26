import java.io.*;
import java.util.*;

public class WhereAmI {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("whereami.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
		
		int n = readInt(); String str = readLine();
		for (int i = 1; i <= n; i ++) {
			ArrayList<String> arr = new ArrayList<String>();
			boolean flag = true;
			for (int j = 0; j <= n - i; j ++) {
				String temp = str.substring(j, j + i);
				if (!arr.contains(temp)) arr.add(temp);
				else { flag = false; break; }
			}
			if (flag) {
				pw.println(i);
				break;
			}
		}
		
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
