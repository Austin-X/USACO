import java.io.*;
import java.util.*;

public class OutOfPlace {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("outofplace.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		
		int n = readInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i ++) { 
			int x = readInt();
			if (a.isEmpty() || a.get(a.size() - 1) != x) a.add(x);
		}
		int ans = 0; n = a.size();
		Integer[] arr = a.toArray(new Integer[0]);
		for (int i = 1; i < n; i ++) {
			if (arr[i] < arr[i - 1]) {
				ans ++;
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
		}
		for (int i = n - 1; i >= 1; i --) {
			if (arr[i] < arr[i - 1]) {
				ans ++;
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
			}
		}
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
