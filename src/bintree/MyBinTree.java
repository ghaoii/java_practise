package bintree;


import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class TreeNode<E>{
    E val;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E val) {
        this.val = val;
    }
}

public class MyBinTree<E> {
    TreeNode<Integer> root;

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

    public void preOrder(TreeNode<E> root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderNonRecursion(TreeNode<E> root){
        if(root == null){
            throw new NoSuchElementException("BinTree is empty!");
        }
        Deque<TreeNode<E>> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode<E> cur = stack.pop();
            System.out.print(cur.val + " ");
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void inOrder(TreeNode<E> root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void inOrderNonRecursion(TreeNode<E> root){
        if(root == null){
            throw new NoSuchElementException("BinTree is empty!");
        }
        Deque<TreeNode<E>> stack = new LinkedList<>();
        TreeNode<E> cur = root;
        while(cur != null || !stack.isEmpty()){
            //?????????????????????cur????????????????????????????????????????????????????????????cur?????????
            //???????????????????????? - ??????????????????????????????cur??????????????????????????????
            //???????????????cur??????cur???????????????????????????
            //???????????????????????????????????????????????????????????????????????????????????????
            //??????????????????cur??????????????????????????????????????????????????????1?????????2??????????????????????????????????????????????????????????????????????????????
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");

            cur = cur.right;
        }
    }

    public void postOrder(TreeNode<E> root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void postOrderNonRecursion(TreeNode<E> root){
        if(root == null){
            throw new NoSuchElementException("BinTree is empty!");
        }
        Deque<TreeNode<E>> stack = new LinkedList<>();
        TreeNode<E> cur = root;
        TreeNode<E> prev = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//
            if(cur.right != null && cur.right != prev){
                //???????????????????????????????????????????????????????????????
                stack.push(cur);
                cur = cur.right;
            }else{
                //???????????????????????????????????????????????????????????????
                System.out.print(cur.val + " ");
                prev = cur;
                cur = null;//??????????????????????????????????????????
            }
        }
    }

    public int getNodes(TreeNode<E> root){
        if(root == null){
            return 0;
        }
        return 1 + getNodes(root.left) + getNodes(root.right);
    }

    public int getNodesNonRecursion(TreeNode<E> root){
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode<E> cur = queue.poll();
            count++;
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer((cur.right));
            }
        }
        return count;
    }

    public int getLeafNodes(TreeNode<E> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafNodes(root.left) + getLeafNodes(root.right);
    }

    public int getLeafNodesNonRecursion(TreeNode<E> root){
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode<E> cur = queue.poll();
            if(cur.left == null && cur.right == null){
                count++;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return count;
    }

    public int getKLevelNode(TreeNode<E> root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelNode(root.left, k - 1) + getKLevelNode(root.right, k - 1);
    }

    public int getKLevelNodeNonRecursion(TreeNode<E> root, int k){
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(k == 1){
                return size;
            }
            for (int i = 0; i < size; i++) {
                TreeNode<E> cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            k--;
        }
        return -1;
    }

//    public int height(TreeNode<E> root){
//        if(root == null){
//            return 0;
//        }
//        return 1 + Math.max(height(root.left), height(root.right));
//    }

    public int height(TreeNode<E> root){
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        int k = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<E> cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            k++;
        }
        return k;
    }

//    public boolean contains(TreeNode<E> root, E val){
//        if(root == null){
//            return false;
//        }
//        if(root.val == val){
//            return true;
//        }
//        return contains(root.left, val) || contains(root.right, val);
//    }

    public boolean contains(TreeNode<E> root, E val){
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<E> cur = queue.poll();
            if(cur.val == val){
                return true;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return false;
    }

    public void levelOrder(TreeNode<E> root){
        if(root == null){
            throw new NoSuchElementException("BinTree is empty!");
        }
        Deque<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<E> cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}
