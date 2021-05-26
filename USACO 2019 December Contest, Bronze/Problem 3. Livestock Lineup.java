import java.io.*;
import java.util.*;

public class LivestockLineup {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	static String[] arr  = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
	static boolean[][] constraints = new boolean[8][8];
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("lineup.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
		
		int n = readInt();
		for (int i = 0; i < n; i ++) {
			String[] s = readLine().split(" ");
			int x = 0, y = 0;
			for (int j = 0; j < 8; j ++) { 
				if (arr[j].equals(s[0])) x = j;
				else if (arr[j].equals(s[5])) y = j;
			}
			constraints[x][y] = true; constraints[y][x] = true;
		}
		solve(new ArrayList<Integer>());
	}

	static void solve(ArrayList<Integer> cur) {
		if (cur.size() == 8) {
			boolean[][] temp = new boolean[8][8];
			for (int i = 0; i < 8; i ++) temp[i] = Arrays.copyOf(constraints[i], 8);

			for (int i = 0; i < cur.size() - 1; i ++) {
				temp[cur.get(i)][cur.get(i + 1)] = false; temp[cur.get(i + 1)][cur.get(i)] = false;
			}
			boolean flag = true;
			for (int i = 0; i < 8; i ++)
				for (int j = 0; j < 8; j ++) if (temp[i][j] == true) flag = false;
			
			if (flag) {
				for (int x: cur) pw.println(arr[x]);
				pw.close();
				System.exit(0);
			}
		}
		
		for (int i = 0; i < 8; i ++) {
			if (!cur.contains(i)) {
				cur.add(i);
				solve(cur);
				cur.remove(cur.size() - 1);
			}
		}
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
