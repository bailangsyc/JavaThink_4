package innerclass;

/**
 * 10.8 为什么需要内部类
 * 内部类继承自某个类或实现某个接口，内部类的代码操作创建它的外围类的对象，所以可以认为内部类提供了某种进入外围类的窗口。
 *
 *如果只是需要一个对接口的引用，那么为什么不通过外围类来实现那个接口，两者的区别是：
 *   外围类实现接口不是总能享受接口带来的方便，有时需要用到接口的实现.内部类最吸引人的原因时：
 *   每个内部类都能独立的继承一个接口的实现，所以无论外围类是否已经继承了某个接口的实现，对内部类都是没有任何影响的，
 *   suomi内部类可以有效的实现“多重继承”。也就是说内部类允许继承多个非接口类型（类或者抽象类）
 *
 *
 * Created by root on 17-9-17.
 */

interface A{}
interface B{}

//两种方式实现 两个接口
//第一种
class X implements A, B {

}

//第二种 内部类实现
class Y implements  A {

    B makeB() {
        return new B() {
        };
    }

}


public class MultiInterfaces {
    static void takesA(A a) {

    }

    static void takesB(B b) {

    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takesA(x);
        takesA(y);

        takesB(x);
        takesB(y.makeB());
    }



}
