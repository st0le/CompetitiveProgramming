package org.exor.SPOJ.GIWED_;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private int M, N, K, L;
    private boolean[][] grid;
    private int[] stack;

    private void printGrid() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++)
                sb.append(grid[i][j] ? '1' : '0');
            sb.append('\n');
        }
        out.println(sb.toString());
    }

    public void solve() throws Exception {
        init();
        int MAX = 10000;
        grid = new boolean[MAX][MAX];
        stack = new int[MAX * 2];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            resetGrid();
            M = nextInt();
            N = nextInt();
            K = nextInt();
            L = nextInt();
            for(int i = 0; i < K; i++) {
                int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt();
                for(int x = x1; x < x2; x++)
                    for(int y = y1; y < y2; y++)
                        grid[x][y] = true;
            }
            out.println(maxArea());
        }
        // ----- solution ends here -----
        out.flush();
    }

    private void resetGrid() {
        for(boolean[] bs: grid)
            Arrays.fill(bs, false);
    }

    private int maxArea() {
        List<Integer> list = new ArrayList<Integer>();
        for(int x = 0; x < M; x++) {
            for(int y = N / 2; y < N; y++) {
                if(!grid[x][y]) {
                    list.add(floodFill(x, y));
                }
            }
            for(int y = 0; y < N / 2; y++) {
                if(!grid[x][y]) {
                    list.add(floodFill(x, y));
                }
            }
        }
        int s = 0;
        for(int i = list.size() - 1, c = L; c > 0; c--, i--)
            s += list.get(i);
        return s;
    }

    private int floodFill(int x, int y) {
        if(grid[x][y])
            return 0;
        int c = 0;
        int top = -1;
        stack[++top] = x;
        stack[++top] = y;
        while(top > 0) {
            y = stack[top--];
            x = stack[top--];
            if(!grid[x][y]) {
                grid[x][y] = true;
                c++;
            }
            else
                continue;
            int s = y - 1;
            while(s >= 0 && !grid[x][s])
                s--;
            s++;
            int e = y + 1;
            while(e < N && !grid[x][e])
                e++;
            e--;
            for(y = s; y <= e; y++) {
                if(x + 1 < M && !grid[x + 1][y]) {
                    stack[++top] = x + 1;
                    stack[++top] = y;
                }

                if(x - 1 >= 0 && !grid[x - 1][y]) {
                    stack[++top] = x - 1;
                    stack[++top] = y;
                }
            }
        }
        return c;
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
