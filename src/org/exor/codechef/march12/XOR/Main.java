package org.exor.codechef.march12.XOR;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	class BinaryMinHeap {

		private final int[] data;
		private int heapSize;

		public BinaryMinHeap(int size) {
			data = new int[size];
			heapSize = 0;
		}

		public boolean isEmpty() {
			return (heapSize == 0);
		}

		private int getLeftChildIndex(int nodeIndex) {
			return 2 * nodeIndex + 1;
		}

		private int getRightChildIndex(int nodeIndex) {
			return 2 * nodeIndex + 2;
		}

		private int getParentIndex(int nodeIndex) {
			return (nodeIndex - 1) / 2;
		}

		private void clear() {
			heapSize = 0;
		}

		public int removeMin() throws Exception {
			if (isEmpty())
				throw new Exception("Heap is empty");
			else {
				int hold = data[0];
				data[0] = data[heapSize - 1];
				heapSize--;
				if (heapSize > 0)
					siftDown(0);
				return hold;
			}

		}

		public void insert(int value) throws Exception {
			if (heapSize == data.length)
				throw new Exception("Heap's underlying storage is overflow");
			else {
				heapSize++;
				data[heapSize - 1] = value;
				siftUp(heapSize - 1);
			}
		}

		private void siftUp(int nodeIndex) {
			int parentIndex, tmp;
			if (nodeIndex != 0) {
				parentIndex = getParentIndex(nodeIndex);
				if (data[parentIndex] > data[nodeIndex]) {
					tmp = data[parentIndex];
					data[parentIndex] = data[nodeIndex];
					data[nodeIndex] = tmp;
					siftUp(parentIndex);
				}
			}
		}

		private void siftDown(int nodeIndex) {
			int leftChildIndex, rightChildIndex, minIndex, tmp;
			leftChildIndex = getLeftChildIndex(nodeIndex);
			rightChildIndex = getRightChildIndex(nodeIndex);
			if (rightChildIndex >= heapSize) {
				if (leftChildIndex >= heapSize)
					return;
				else
					minIndex = leftChildIndex;
			} else {
				if (data[leftChildIndex] <= data[rightChildIndex])
					minIndex = leftChildIndex;
				else
					minIndex = rightChildIndex;
			}
			if (data[nodeIndex] > data[minIndex]) {
				tmp = data[minIndex];
				data[minIndex] = data[nodeIndex];
				data[nodeIndex] = tmp;
				siftDown(minIndex);
			}
		}
	}

	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		final int MAX = 100000 + 1;
		BinaryMinHeap pq = new BinaryMinHeap(MAX);
		int N = nextInt();
		int K = nextInt();
		int[] arr = new int[MAX];
		for (int i = 0; i < N; i++) {
			arr[i] = nextInt();
		}
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				pq.insert(arr[i] ^ arr[j]);
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < K; k++) {
			if (k > 0)
				sb.append(' ');
			sb.append(pq.removeMin());
		}
		out.println(sb.toString());
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
