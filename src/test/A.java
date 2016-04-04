/**
 * author : Jerry
 **/
package test;

/**
 * Created by sooglejay on 4/3/16.
 */
public class A {

    void draw(){
        System.out.println("A draw()");
    }

    public A() {
        System.out.println("A() before draw()");
        draw();
        System.out.println("A() after draw()");
    }
}
