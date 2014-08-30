package org.exor.SPOJ.NY10A;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		String[] arr = "TTT,TTH,THT,THH,HTT,HTH,HHT,HHH".split(",");
		for (int testCase = 0, T = nextInt(); testCase < T; testCase++) {
			for (String s : arr)
				map.put(s, 0);
			scan.readLine(); // ignore
			String line = scan.readLine();
			for (int i = 0, l = line.length(); i + 3 <= l; i++)
				map.put(line.substring(i, i + 3),
						map.get(line.substring(i, i + 3)) + 1);
			StringBuilder sb = new StringBuilder();
			sb.append(testCase + 1);
			for (String k : map.keySet())
				sb.append(' ').append(map.get(k));
			out.println(sb.toString());
		}
		// ----- solution ends here -----
		out.flush();
	}

	private StringTokenizer st;
	private BufferedReader scan;
	private PrintWriter out;

	public int nextInt() throws Exception {
		return Integer.valueOf(nextToken());
	}

	public long nextLong() throws Exception {
		return Long.valueOf(nextToken());
	}

	public BigInteger nextBigInteger() throws Exception {
		return new BigInteger(nextToken());
	}

	public float nextFloat() throws Exception {
		return Float.valueOf(nextToken());
	}

	public Double nextDouble() throws Exception {
		return Double.valueOf(nextToken());
	}

	public String nextToken() throws Exception {
		if (st == null || !st.hasMoreTokens()) {
			String line = null;
			while ((line = scan.readLine()) != null) {
				if (line.length() > 0)
					break;
			}
			if (line == null)
				return null;
			st = new StringTokenizer(line);
		}
		return st == null ? null : st.nextToken();
	}

	public void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}

	public static void main(String[] args) throws Exception {
		new Main().solve();
	}

	private void init() {
		scan = new BufferedReader(new InputStreamReader(System.in), 500 * 1024);
		out = new PrintWriter(new BufferedOutputStream(System.out));
	}

}
