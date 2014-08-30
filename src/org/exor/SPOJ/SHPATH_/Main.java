package org.exor.SPOJ.SHPATH_;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        index = new Index();
        City[] cities = new City[100001];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            index.clear(); // reset index
            int n = nextInt();
            for(int i = 1; i <= n; i++) {
                cities[i] = nextCity();
            }
            int r = nextInt();
            for(int i = 0; i < r; i++) {
                int src = index.indexOf(nextToken()), dst = index.indexOf(nextToken());
                out.println(findMinCost(cities, src, dst, n));
            }
        }
        // ----- solution ends here -----
        out.flush();
    }

    public class HeapComparator implements Comparator<Integer> {
        private final int[] minCost;

        public HeapComparator(int[] minCost) {
            this.minCost = minCost;
        }

        @Override
        public int compare(Integer a, Integer b) {
            return minCost[a] <= minCost[b] ? -1 : 1;
        }

    }

    public class BinaryMinHeap {

        private final int[] data;
        private int heapSize;
        private final HeapComparator cmp;

        public BinaryMinHeap(int size, HeapComparator cmp) {
            data = new int[size + 10];
            heapSize = 0;
            this.cmp = cmp;
        }

        public boolean isEmpty() {
            return(heapSize == 0);
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

        public int removeMin() throws Exception {
            if(isEmpty())
                throw new Exception("Heap is empty");
            else {
                int hold = data[0];
                data[0] = data[heapSize - 1];
                heapSize--;
                if(heapSize > 0)
                    siftDown(0);
                return hold;
            }
        }

        public void insert(int value) {
            if(heapSize < data.length) {
                heapSize++;
                data[heapSize - 1] = value;
                siftUp(heapSize - 1);
            }
        }

        private void siftUp(int nodeIndex) {
            int parentIndex, tmp;
            if(nodeIndex != 0) {
                parentIndex = getParentIndex(nodeIndex);
                if(cmp.compare(data[parentIndex], data[nodeIndex]) > 0) {
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
            if(rightChildIndex >= heapSize) {
                if(leftChildIndex >= heapSize)
                    return;
                else
                    minIndex = leftChildIndex;
            }
            else {
                // (data[leftChildIndex] <= data[rightChildIndex])
                if(cmp.compare(data[leftChildIndex], data[rightChildIndex]) <= 0)
                    minIndex = leftChildIndex;
                else
                    minIndex = rightChildIndex;
            }
            // data[nodeIndex] > data[minIndex]
            if(cmp.compare(data[nodeIndex], data[minIndex]) > 0) {
                tmp = data[minIndex];
                data[minIndex] = data[nodeIndex];
                data[nodeIndex] = tmp;
                siftDown(minIndex);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(data);
        }
    }

    private int findMinCost(City[] cities, int src, int dst, int n) { // Dijkstra
        boolean[] visited = new boolean[n + 1];
        // minCost[i] is minCost from src to i
        int[] minCost = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE / 2);
        BinaryMinHeap Q = new BinaryMinHeap(n, new HeapComparator(minCost));
        Q.insert(src);
        minCost[src] = 0;
        while(!Q.isEmpty()) {
            try {
                int cur = Q.removeMin();
                // out.println("Visiting " + cur);
                visited[cur] = true;
                if(cur == dst)
                    break;
                for(int i = 0; i < cities[cur].p; i++) {
                    int v = cities[cur].neighbours[i];
                    int cost = cities[cur].costs[i];
                    if(!visited[v]) {
                        // out.println("Found Unvisited neighbour " + v);
                        if(minCost[v] > minCost[cur] + cost)
                            minCost[v] = minCost[cur] + cost;
                        Q.insert(v);
                    }
                }
                // out.println(Q.toString());
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return minCost[dst];
    }

    private City nextCity() throws Exception {
        City city = new City();
        city.ccode = index.indexOf(nextToken());
        city.p = nextInt();
        city.neighbours = new int[city.p];
        city.costs = new int[city.p];
        for(int i = 0; i < city.p; i++) {
            city.neighbours[i] = nextInt();
            city.costs[i] = nextInt();
        }
        return city;

    }

    private class City {
        int ccode, p;
        int[] neighbours, costs;
    }

    private class Index {
        private final Map<String, Integer> map = new HashMap<String, Integer>();
        private final java.util.List<String> list = new ArrayList<String>();

        public int indexOf(String value) {
            Integer id = map.get(value);
            if(id == null) {
                map.put(value, id = map.size() + 1);
                list.add(value);
            }
            return id;
        }

        public String at(int id) {
            return list.get(id);
        }

        public void clear() {
            map.clear();
            list.clear();
        }
    }

    private StringTokenizer st;
    private BufferedReader scan;
    private PrintWriter out;
    private Index index;

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
        if(st == null || !st.hasMoreTokens()) {
            String line = scan.readLine();
            if(line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
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
