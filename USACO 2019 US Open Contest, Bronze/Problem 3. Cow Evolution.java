import java.io.*;
import java.util.*;

public class CowEvolution {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("evolution.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
		
		int n = readInt();
		int[] arr = new int[n];
		@SuppressWarnings("unchecked")
		ArrayList<String>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i ++) adj[i] = new ArrayList<String>();
		
		for (int i = 0; i < n; i ++) {
			arr[i] = readInt();
			for (int j = 0; j < arr[i]; j ++) adj[i].add(next());
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		boolean flag = true;
		outerloop: for (int i = 0; i < n; i ++) {
			for (int j = 0; j < arr[i]; j ++) {
				for (int k = j + 1; k < arr[i]; k ++) {
					String str1 = adj[i].get(j), str2 = adj[i].get(k);
					for (int r = 0; r < n; r ++) {
						if (r == i) continue;
						if (adj[r].contains(str1) && !adj[r].contains(str2)) {
							if (map.containsKey(str2) && map.get(str2).equals(str1)) { flag = false; break outerloop; }
							map.put(str1, str2);
						} else if (!adj[r].contains(str1) && adj[r].contains(str2)) {
							if (map.containsKey(str1) && map.get(str1).equals(str2)) { flag = false; break outerloop; }
							map.put(str2, str1);
						}
					}
				}
			}
		}
		
		pw.println(flag ? "yes" : "no");
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
