/**
 * author : Jerry
 **/
package algorithm.Tree;

/**
 * Created by sooglejay on 16/8/5.
 */
public class Node {
    public Node left;
    public Node right;
    public Node parent;
    public int key;

    public Node(int key) {
        this.key = key;
    }

    public Node() {
    }
}
