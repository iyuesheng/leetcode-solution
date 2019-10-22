package cn.iisheng.solution.dfs;

import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/23 01:44:32
 */
public class No_0559_MaximumDepthOfNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int result = 0;
            List<Node> children = root.children;
            for (int i = 0; i < children.size(); i++) {
                int temp = maxDepth(children.get(i));
                if (temp > result) {
                    result = temp;
                }
            }
            return result + 1;
        }
    }

    public static void main(String[] args) {

    }
}
