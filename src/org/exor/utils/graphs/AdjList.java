package org.exor.utils.graphs;


public class AdjList {

    class AdjNode {
        public AdjNode(int v, int w, AdjNode next) {
            this.v = v;
            this.w = w;
            this.next = next;
        }

        int v;
        int w;
        AdjNode next;
    }

    private final AdjNode[] _u;

    public AdjList(int V) {
        _u = new AdjNode[V];
    }

    public void addEdge(int u, int v) {
        _u[u] = new AdjNode(v, 0, _u[u]);
    }

    public void addEdge(int u, int v, int w) {
        _u[u] = new AdjNode(v, w, _u[u]);
    }

    public AdjNode getEdges(int u) {
        return _u[u];
    }
}
