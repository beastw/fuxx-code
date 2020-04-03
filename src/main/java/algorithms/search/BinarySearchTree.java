package algorithms.search;

/**
 * 二叉搜索树
 * Created by liuwei on 2020/4/1
 */
public class BinarySearchTree {

    private Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node (int value) {
            this.value = value;
        }
    }

    public int get(int value) {
        return get(root, value);
    }

    public int get1(int value) {
        Node temp = root;
        while(temp != null) {
            if (temp.value == value) {
                return 0;
            } else if (value > temp.value) {
                temp = root.right;
            } else {
                temp = root.left;
            }
        }
        return -1;
    }

    private int get(Node node, int value) {
        if (node == null) {
            return -1;
        }
        if (node.value == value) {
            return 0;
        } else if (value > node.value) {
            return get(node.right, value);
        } else {
            return get(node.left, value);
        }
    }

    public void put(int value) {
        root = put(root, value);
    }

    private Node put(Node node, int value) {
        if (node == null) {
            return new Node (value);
        }
        if (value < node.value) {
            //插入到左子树
            node.left = put(node.left, value);
        } else if (value > root.value) {
            //插入到右子树
            node.right = put(node.right, value);
        } else {
            node.value = value;
        }
        return node;
    }
}
