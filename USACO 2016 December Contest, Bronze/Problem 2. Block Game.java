import java.io.*;
import java.util.*;

public class BlockGame {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("blocks.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		
		int n = readInt();
		int[] ans = new int[26];
		String[][] arr = new String[n][2];
		for (int i = 0; i < n; i ++) { arr[i][0] = next(); arr[i][1] = next(); }
		for (int i = 0; i < 26; i ++) {
			for (int j = 0; j < n; j ++) {
				String str1 = arr[j][0], str2 = arr[j][1];
				int cnt1 = 0, cnt2 = 0;
				for (int k = 0; k < str1.length(); k ++) if (str1.charAt(k) - 97 == i) cnt1 ++;
				for (int k = 0; k < str2.length(); k ++) if (str2.charAt(k) - 97 == i) cnt2 ++;
				ans[i] += Math.max(cnt1, cnt2);
			}
		}
		for (int i = 0; i < 26; i ++) pw.println(ans[i]);
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
