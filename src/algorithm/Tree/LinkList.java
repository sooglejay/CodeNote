/**
 * author : Jerry
 **/
package algorithm.Tree;

import java.text.NumberFormat;

/**
 * Created by sooglejay on 16/8/5.
 */
public class LinkList {
    public static Node T;

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        node1.key = 12;
        node2.key = 6;
        node3.key = 15;
        node4.key = 18;
        node5.key = 13;
        node6.key = 11;
        insert(T, node1);
        insert(T, node2);
        insert(T, node3);
        insert(T, node4);
        insert(T, node5);
        insert(T, node6);

        treeWalk(T);
        System.out.print("\n 删除后");
        delete(node1);
        treeWalk(T);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(40);
        System.out.print("\n\n"+nf.format(Math.pow(95.123 ,2))+  "  \n"+Math.pow(95.123 ,12));


    }

    /**
     * 二叉搜索树 插入时,根本不需要管 插入的该结点的left和right,因为他们始终为空
     *
     * @param root
     * @param z
     */
    public static void insert(Node root, Node z) {
        if (z == null) return;
        if (root == null) {
            T = z;
            return;
        }
        Node y = null;
        while (root != null && root.key != z.key) {
            y = root;
            if (root.key > z.key) {
                root = root.left;
            } else if (root.key < z.key) {
                root = root.right;
            }
        }
        if (y == null) {
            return;
        }
        z.parent = y;
        if (y.key > z.key) {
            y.left = z;
        } else if (y.key < z.key) {
            y.right = z;
        }
    }

    public static Node search(Node root, int k) {
        if (root == null || root.key == k) {
            return root;
        }
        if (root.key > k) {
            return search(root.left, k);
        }
        return search(root.right, k);
    }

    public static void treeWalk(Node root) {
        if (root != null) {
            treeWalk(root.left);
            System.out.print(root.key + " ");
            treeWalk(root.right);
        }
    }

    public static void delete(Node z) {
        if (T == null || z == null) {
            return;
        }
        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            Node y = getSuccessor(z);
            if (y.parent != z) {
                //这里先解决z的右孩子的问题,只有y不是z的直系孩子,才需要,因为若y是z的直系孩子,则y肯定是z的右孩子

                //由于不是直系,并且y一定在z的右子树中,y也没有左孩子! 这是因为如果y有左孩子,则y就应该是其左孩子
                //先解决y的右孩子的归属问题,不管y有没有右孩子
                transplant(y, y.right);
                //然后解决z的直系右孩子的双亲问题,意思是告诉z的右孩子,z马上就要驾崩了,你们的新双亲是y
                y.right = z.right;
                //y.right也要反向认定一下自己的双亲就是y
                y.right.parent = y;

            }
            //不管y是不是z的直系孩子,由于y肯定是没有左孩子的,所以都要将原来z的左孩子,过继给y

            //首先 用y替换z
            transplant(z, y);
            // 解决左边的各种关系
            y.left = z.left;
            // 解决反向关系
            y.left.parent = y;
        }
    }

    public static void transplant(Node u, Node v) {
        if (u == null) {
            return;
        }
        if (u.parent == null) {
            T = v;
            return;
        }
        //替换操作是先整孩子,整完孩子的归属问题,再整双亲
        Node parent = u.parent;
        if (parent.left != null && u == parent.left) {
            u.parent.left = v;
            return;
        }
        if (parent.right != null && u == parent.right) {
            u.parent.right = v;
            return;
        }
        if (v != null && v.parent != null) {
            v.parent = u.parent;
        }
    }

    public static Node getSuccessor(Node y) {
        if (y.right != null) {
            return getMinimum(y.right);
        }
        Node t = y.parent;
        while (t != null && y == t.right) {
            y = t;
            t = t.parent;
        }
        return t;

    }

    public static Node getMinimum(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

}
