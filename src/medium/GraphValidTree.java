package medium;

/**
 * Created by GAOSHANSHAN835 on 2016/5/7.
 */
/**Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 For example:
 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], returntrue.
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], returnfalse.
 */

/**树的特点有两个 一个是节点是全连同的 另一个是是一个没有环的图
 这里有一个简便方法就是检查edge的数量必须是n-1(对于无向图来说) 这样才有可能是一个树
 这道题使用的dfs来检测 整体思路和之前的都类似 需要记录访问过的点 然后把要访问的点不停的入栈 每次弹出栈顶的一个点  然后继续入栈他的邻居
 有必要总结一些leetcode里的图的题 总结一下bfs dfs 拓扑排序*/
/**没有cycle的图就是树*/
public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println(graphValidTree(5, edges));
        System.out.println(graphValidTree(5, edges2));
    }

    public static boolean graphValidTree(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int root1 = find(root, edges[i][0]);
            int root2 = find(root, edges[i][1]);
            if (root1 == root2)
                return false;
            root[root2] = root1;
        }
        return edges.length == n - 1;
    }

    private static int find(int[] root, int e) {
        if (root[e] == e)
            return e;
        else
            return find(root, root[e]);
    }
}