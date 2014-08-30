package org.exor.SPOJ.DICT_;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    class Trie {

        private class TNode {
            private final char c;
            private final int len;
            private TNode[] child;
            private boolean EOW;

            public TNode(char c, int len) {
                this.c = Character.toLowerCase(c);
                this.len = len;
                this.EOW = false;
            }

            public void setEndOfWord(boolean b) {
                this.EOW = b;
            }

            public TNode getChild(char c) {
                return (child == null) ? null
                                      : child[Character.toLowerCase(c) - 'a'];
            }

            public TNode addChild(char next) {
                if(child == null)
                    child = new TNode[26];
                return child[Character.toLowerCase(next) - 'a'] = new TNode(next,
                                                                            len + 1);
            }
        }

        private final TNode root;

        public Trie() {
            root = new TNode((char)0, 0);
        }

        private TNode findPrefixNode(String text) {
            if(text == null || text.length() == 0)
                return root;
            TNode node = root;
            for(char c: text.toCharArray()) {
                TNode nextNode = node.getChild(c);
                if(nextNode == null)
                    return node;
                node = nextNode;
            }
            return node;
        }

        public void prefixSearch(String prefix) {
            if(prefix == null || prefix.length() == 0)
                return;
            TNode prefixNode = findPrefixNode(prefix);
            if(prefixNode.len < prefix.length()) {
                out.println("No match.");
                return;
            }
            char[] buf = new char[100];
            for(int i = 0; i < prefixNode.len; i++)
                buf[i] = prefix.charAt(i);
            printAll(prefixNode, buf);
        }

        private void printAll(TNode prefixNode, char[] prefix) {

            LinkedList<TNode> stack = new LinkedList<TNode>();
            stack.push(prefixNode);
            while(!stack.isEmpty()) {
                TNode node = stack.pollLast();
                prefix[node.len - 1] = node.c;
                if(node != null && node.child != null) {
                    for(TNode child: node.child) {
                        if(child != null) {
                            prefix[child.len - 1] = child.c;
                            if(child.EOW) {
                                for(int i = 0; i < child.len; i++)
                                    out.print(prefix[i]);
                                out.println();
                            }
                            stack.push(child);
                        }
                    }
                }
            }
        }

        public void addWord(String word) {
            if(word == null || word.length() == 0)
                return;
            TNode node = findPrefixNode(word);
            int l = word.length();
            for(int i = node.len; i < l; i++)
                node = node.addChild(word.charAt(i));
            node.setEndOfWord(true);
        }
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        Trie t = new Trie();
        int N = Integer.valueOf(scan.readLine());
        while(N-- > 0)
            t.addWord(scan.readLine());
        for(int testCase = 0, T = Integer.valueOf(scan.readLine()); testCase < T; testCase++) {
            out.println(String.format("Case #%d:", testCase + 1));
            t.prefixSearch(scan.readLine());
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
        if(st == null || !st.hasMoreTokens()) {
            String line = null;
            while((line = scan.readLine()) != null) {
                if(line.length() > 0)
                    break;
            }
            if(line == null)
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
        scan = new BufferedReader(new InputStreamReader(System.in),
                                  20 * 1024 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out,
                                                       20 * 1024 * 1024));
    }

}
