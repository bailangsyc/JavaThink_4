package innerclass;

/**
 * 10.6匿名内部类
 * <p>
 * 在匿名内部类中时不可能有命名的构造器（因为它根本没有名字），那么如果在匿名内部类中做一些类似构造器的行为呢，
 * 可以通过实例初始化，为匿名内部类创建一个构造器的效果
 * <p>
 * Created by root on 17-9-15.
 */

//抽象类
abstract class Base {
    {
        System.out.println("基类的初始化");
    }

    //抽象类base中有一个带参构造
    public Base(int i) {
        System.out.println("Base Constuctor. i = " + i);
    }
    //抽象的方法
    abstract void f();
}

public class AnonymousConstructor {

    public static Base getBase(int i ) {//因为i没有在匿名类中直接使用，所以不用final修饰
        //返回一个匿名的对象
        return new Base(i) {
            {
                System.out.println("匿名内部类的实例初始化");
            }

            //注意匿名内部类中是不可能有构造器的操作（下方的代码），因为它根本没有名字
//            public Base(int i) {
//                System.out.println("Base Constuctor. i = " + i);
//            }

            @Override
            void f() {
                System.out.println("内部类的方法 f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = AnonymousConstructor.getBase(10);
        base.f();
    }



}
