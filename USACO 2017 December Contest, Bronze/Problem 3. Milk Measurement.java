import java.io.*;
import java.util.*;

public class MilkMeasurement {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static class Tuple implements Comparable<Tuple> {
		int day, val;
		String cow;
		Tuple (int day, String cow, int val) { this.day = day; this.cow = cow; this.val = val; }
		public int compareTo(Tuple t) { return Integer.compare(day, t.day); }
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("measurement.in"));
		pw = new PrintWriter("measurement.out");
		
		int n = readInt();
		Tuple[] arr = new Tuple[n];
		for (int i = 0; i < n; i ++) arr[i] = new Tuple(readInt(), next(), Integer.parseInt(next()));
		Arrays.sort(arr);
		
		int ans = 0;
		String cur = "111";
		int[] output = new int[3]; Arrays.fill(output, 7);
		for (int i = 0; i < n; i ++) {
			String cow = arr[i].cow;
			if (cow.equals("Bessie")) output[0] += arr[i].val;
			else if (cow.equals("Elsie")) output[1] += arr[i].val;
			else output[2] += arr[i].val;
			
			int mx = 0;
			for (int j = 0; j < 3; j ++) mx = Math.max(mx, output[j]);
			String temp = "";
			for (int j = 0; j < 3; j ++) {
				if (output[j] == mx) temp += '1';
				else temp += '0';
			}
			if (!cur.equals(temp)) { ans ++; cur = temp; }
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
