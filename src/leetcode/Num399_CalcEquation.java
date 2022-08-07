package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num399_CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        Map<String,Integer> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(2 * size);

        int id = 0;
        for (int i = 0; i < size; i++) {
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);
            if(!map.containsKey(str1)) {
                map.put(str1, id);
                id++;
            }
            if(!map.containsKey(str2)) {
                map.put(str2, id);
                id++;
            }
            unionFind.union(map.get(str1), map.get(str2), values[i]);
        }

        int len = queries.size();
        double[] ret = new double[len];
        for (int i = 0; i < len; i++) {
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            if(map.containsKey(str1) && map.containsKey(str2)) {
                int x = map.get(str1);
                int y = map.get(str2);
                ret[i] = unionFind.calculate(x, y);
            }else {
                ret[i] = -1;
            }
        }
        return ret;
    }

    private class UnionFind {
        int[] parent;
        double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i++) {
                // 最开始让每个结点的父节点都指向自己，权重都是1
                parent[i] = i;
                weight[i] = 1.0;
            }
        }

        /**
         * 合并
         */
        public void union(int x, int y, double value) {
            // 找到父结点，过程中，会压缩路径
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                // 父结点已经相同了
                return;
            }
            // 父结点不同, 让x的根节点指向y的根节点
            parent[rootX] = rootY;
            // 设置权重：x经过rootX到rootY的权重 = x经过y到rootY的权重
            weight[rootX] = value * weight[y] / weight[x];
        }

        /**
         * 查询父结点，同时压缩路径
         * @param x
         * @return
         */
        public int find(int x) {
            // 如果已经是父结点了，直接返回
            if(x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(origin);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double calculate(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return weight[x] / weight[y];
            }
            return -1.0;
        }
    }
}
