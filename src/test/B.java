/**
 * author : Jerry
 **/
package test;

/**
 * Created by sooglejay on 4/3/16.
 */
public class B extends A {
    int anInt =1001;
    void draw() {
        System.out.println("B.draw()  aInt="+anInt);
    }


    /**
     * B Construct , at first , A Construct will be invoked , as we can see,  draw() function will be invoked in A construct , at this time ,B.draw() will be invoked instead of A.draw() because of override
     * @param a
     */
    public B(int a) {
        System.out.println("B() the first line  aInt="+anInt);
        anInt = a;
        super.draw();
        System.out.println("B() aInt="+anInt);
    }

    public static void main(String[] args) {
        new B(1);

    }
}
