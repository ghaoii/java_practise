package bintree;

import java.util.Deque;
import java.util.LinkedList;

public class TreePractise {
    private TreeNode<Integer> root;

    public void build(){
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node8 = new TreeNode<>(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node7.right = node8;
        root = node1;
    }

    public void preOrder(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public void levelOrder(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            System.out.println(node.val);
            if(root.left != null) {
                queue.offer(node.left);
            }
            if(root.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void preOrderNonRecursion(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            System.out.println(node.val);
            if(node.right != null) {
                stack.push(root.right);
            }
            if(node.left != null) {
                stack.push(root.left);
            }
        }
    }

    public void inOrderNonRecursion(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> node = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(root);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }

    public void postOrderNonRecursion(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> node = root;
        TreeNode<Integer> prev = null;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(node.right == null || prev == node.right) {
                System.out.println(node.val);
                prev = node;
                node = null;
            }else {
                stack.push(node);
                node = node.right;
            }
        }
    }

    public int getNodes(TreeNode<Integer> root) {
        if(root == null) {
            return  0;
        }
        return 1 + getNodes(root.left) + getNodes(root.right);
    }

    public int getLeafNodes(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodes(root.left) + getLeafNodes(root.right);
    }

    public int getKLevelNodes(TreeNode<Integer> root, int k) {
        if(root == null || k < 1) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelNodes(root.left, k - 1) + getKLevelNodes(root.right, k - 1);
    }

    public int height(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean contains(TreeNode<Integer> root, int val) {
        if(root == null) {
            return false;
        }
        if(root.val == val) {
            return true;
        }
        return contains(root.left, val) || contains(root.right, val);
    }

    public boolean isCompleteTree(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if(!flag) {
                if(node.left == null && node.right != null) {
                    // 没有左子树，有右子树
                    return false;
                }
                if(node.left != null && node.right != null) {
                    // 左右子树均不为空
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else if(node.left != null){
                    // 左子树不为空，右子树为空
                    queue.offer(node.left);
                    flag = true;
                }else {
                    // 为叶子节点
                    flag = true;
                }
            }else {
                if(node.left != null || node.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
