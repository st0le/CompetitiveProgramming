package org.exor.SPOJ.FACEFRND;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public void solve() throws Exception {
		// ----- solution starts here -----
		BufferedReader scan = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		Index index = new Index();
		int nFrnds = Integer.valueOf(scan.readLine());
		BitSet myfrnd = new BitSet(nFrnds * 101); // each frnd can have upto 100
		while ((line = scan.readLine()) != null) {
			if (line.trim().length() == 0)
				continue;
			StringTokenizer st = new StringTokenizer(line);
			int frnd = index.indexOf(st.nextToken());
			myfrnd.set(frnd);
			for (int cnt = Integer.parseInt(st.nextToken()); cnt-- > 0;) {
				myfrnd.set(index.indexOf(st.nextToken()));
			}
		}
		System.out.println(myfrnd.cardinality() - nFrnds);

		// ----- solution ends here -----
		// printRuntimeInfo();
	}

	private class Index {
		private final Map<String, Integer> map = new HashMap<String, Integer>();
		private final java.util.List<String> list = new ArrayList<String>();

		public int indexOf(String value) {
			Integer id = map.get(value);
			if (id == null) {
				map.put(value, id = map.size());
				list.add(value);
			}
			return id;
		}
	}

	public void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}

	public static void main(String[] args) throws Exception {
		new Main().solve();
	}
}
