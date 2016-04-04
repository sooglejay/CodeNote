package leetCode;

import java.util.List;

/**
 * Created by sooglejay on 16/1/15.
 */
public class Print {


    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            println(a[i]);
        }
    }

    public static void print(List<String> a) {
        for (int i = 0; i < a.size(); i++) {
            println(a.get(i));
        }
    }

    public static void println(int[] a) {
        for (int i = 0; i < a.length; i++) {
            println(a[i]);
        }
        println("");

    }

    public static void println(boolean b) {

        System.out.println("" + b);

    }

    public static void print(boolean b) {

        System.out.println("" + b);

    }

    public static void print(int a) {
        System.out.print(a);
    }

    public static void println(int a) {
        System.out.println(a);
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void print(String string) {
        System.out.print(string);
    }


}
