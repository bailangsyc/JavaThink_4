package innerclass;

/**
 * 10.3 使用.this 和 .new
 *
 * 想要在内部类中生成一个外部类的引用,需要使用.this
 * Created by shao on 17-8-12.
 */

public class DoThis {
    public DoThis() {
    }

    void f() {
        System.out.println("DoThis.f()");
    }

    //新建一个inner对象
    public Inner inner() {
        return new Inner();
    }

    //内部类 持有外部类的引用
    public class Inner {
        public Inner() {
        }

        //返回一个外部类的引用
        public DoThis outter() {
            return DoThis.this;//注意此处如果new的话,返回的就不是自身了
        }
    }

    public static void main(String[] args) {
//        不能在静态方法中创建内部类,原因:
//        首先内部类能够访问外部类的成员变量,只有在外部类成员变量只能是在实例创建之后才会初始化,才可被访问
//         main()是静态方法,所以不创建DoThis这个外部实例就可以直接访问,就算内部类Inner可以被创建,那么此时访问外部类的成员变量时访问不到的
//        所以，是不能在静态方法中创建内部类的对象，防止该内部类对象在外部类对象创建前访问外部类的成员变量
//        new Inner();
        DoThis dt = new DoThis();
        Inner inner = dt.inner();
        DoThis outter = inner.outter();
        outter.f();
    }


}
