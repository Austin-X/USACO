import java.io.*;
import java.util.*;

public class RestStops {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new FileReader("reststops.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		
		int l = readInt(), n = readInt(), rf = readInt(), rb = readInt();
		long ans = 0;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(), map2 = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i ++) {
			int x = readInt(), c = readInt();
			if (map.containsKey(c) && x > map.get(c) || !map.containsKey(c)) map.put(c, x);
		}
		for (int x: map.keySet()) map2.put(map.get(x), x);

		int cur = 0;
		while (cur < l) {
			if (map2.higherKey(cur) == null) break;
			int x = map.get(map.lastKey()), c = map.lastKey();
			long bt = (x - cur) * (long)rb, ft = (x - cur) * (long)rf;
			ans += (ft - bt) * c;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int u: map2.keySet()) { 
				if (u == x) { temp.add(u); break; }
				temp.add(u);
			}
			for (int u: temp) { map.remove(map2.get(u)); map2.remove(u); }
			cur = x;
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
