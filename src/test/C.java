/**
 * author : Jerry
 **/
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sooglejay on 4/7/16.
 */
public class C {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> resultList = new ArrayList<>();
//        while (scanner.hasNextInt()) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            resultList.add(a + b);
//        }
//        for (Integer i : resultList) {
//            System.out.println(i);
//        }
//        al();
//        System.out.print(t(9, 16));
        al();
    }

    public static void al() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        List<String> dicList = new ArrayList<>();
        while (a-- > 0) {
            dicList.add(scanner.next());
        }
        int b = scanner.nextInt();
        List<String> tList = new ArrayList<>();
        while (b-- > 0) {
            tList.add(scanner.next());
        }
        List<Integer> resultList = new ArrayList<>();

        Node root = new Node();
        root.sons = new ArrayList<>();
        root.count = -1;
        Node tempRoot;
        //create tree
        for (String str : dicList) {
            tempRoot = root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                Node sonNode = null;
                int tempCount = 0;
                for (Node son : tempRoot.sons) {
                    if (son.ch - ch == 0) {//root already has the node
                        son.count++;
                        if (son.sons == null) {
                            son.sons = new ArrayList<>();
                        }
                        sonNode = son;
                        break;
                    } else {
                        tempCount++;
                    }
                }
                if (tempCount == tempRoot.sons.size()) {// new node
                    sonNode = new Node();
                    sonNode.ch = ch;
                    sonNode.sons = new ArrayList<>();
                    sonNode.count = 1;
                    tempRoot.sons.add(sonNode);
                }
                if (sonNode != null) {//root gets into its son
                    tempRoot = sonNode;
                }
            }


        }

        for (String str : tList) {
            tempRoot = root;
            int resultItem;
            Node sonNode = null;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                sonNode = null;
                for (Node son : tempRoot.sons) {
                    if (son.ch - ch == 0) {//root already has the node
                        sonNode = son;
                        break;
                    }
                }
                if (sonNode != null) {//root gets into its son
                    tempRoot = sonNode;
                } else {
                    break;
                }
            }
            if (tempRoot.count < 0) {//root
                resultItem = 0;
            } else if (sonNode != null) {
                resultItem = sonNode.count;
            } else {
                resultItem = 0;
            }
            resultList.add(resultItem);

        }
        for (Integer integer : resultList) {
            System.out.println(integer);
        }
    }


//
//    public static String t(int n, int radix) {
//        StringBuilder binary = new StringBuilder();
//        for (int i = 1; i <= radix; i++) {
//            int a = (radix - i);
//            int b = n >> a;
//            int c = b & 1;
////            binary.appe
////            nd(c);
//        }
//        return binary.toString();
//    }
//
//    public static String t2(int n, int radix) {
//        StringBuilder binary = new StringBuilder();
//        int a = 7;
//        System.out.print("result:" + ((a >> 1) & 1));
//
//
////        binary.append(n >> (radix - 0) & 1);
//        return binary.toString();
//    }


    private static class Node {
        public char ch;
        public int count;
        public List<Node> sons = new ArrayList<>();

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
}

