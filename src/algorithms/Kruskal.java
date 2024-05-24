package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Kruskal's Algorithm
 * Kruskal's algorithm is a minimum spanning tree algorithm that takes a connected, undirected graph and generates the minimum spanning tree of the graph.
 * 
 * Given a graph, we can use Kruskal’s algorithm to find its minimum spanning tree. If the number of nodes in a graph is V, then each of its spanning trees 
 * should have (V-1) edges and contain no cycles. We can describe Kruskal’s algorithm in the following pseudo-code:
 * Initialize an empty edge set T. 
 * Sort all graph edges by the ascending order of their weight values. 
 * foreach edge in the sorted edge list
 *    Check whether it will create a cycle with the edges inside T.
 *    If the edge doesn't introduce any cycles, add it into T. 
 *    If T has (V-1) edges, exit the loop. 
 * return T
 * 
 * https://yuminlee2.medium.com/kruskals-algorithm-minimum-spanning-tree-db96e91d0aed
 * 
 * 1584. Min Cost to Connect All Points
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */

public class Kruskal {
    record Edge(int u, int v, int w) {}

    public int kruskal(int n, List<Edge> edges) {
        int mst = 0;
        UnionFind cc = new UnionFind(n);
        Collections.sort(edges, (a, b) -> a.w - b.w);

        for(Edge edge : edges) {
            if (cc.find(edge.u) != cc.find(edge.v)) {
                mst += edge.w;
                cc.union(edge.u, edge.v);
            }
        }
        return mst;
    }

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<points.length;++i) {
            for(int j=i+1;j<points.length;++j) {
                edges.add(new Edge(i,j,Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1])));
            }
        }
        return new Kruskal().kruskal(points.length, edges);
    }    

    public static void main(String[] args) {
        Kruskal app = new Kruskal();
        System.out.println(app.minCostConnectPoints(new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
}
