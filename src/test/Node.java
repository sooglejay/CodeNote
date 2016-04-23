/**
 * author : Jerry
 **/
package test;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sooglejay on 4/9/16.
 */
public class Node {
    public char ch;
    public int count;
    public List<Node> sons= new ArrayList<>();

    @Override
    public String toString() {
        return "Node{" +
                "ch=" + ch +
                ", count=" + count +
                ", sons=" + sons +
                '}';
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Node> getSons() {
        return sons;
    }

    public void setSons(List<Node> sons) {
        this.sons = sons;
    }
}
